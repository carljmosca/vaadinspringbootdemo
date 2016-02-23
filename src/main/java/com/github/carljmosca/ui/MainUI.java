/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.ui;

import com.github.carljmosca.data.DemoAppData;
import com.github.carljmosca.data.Widget;
import com.github.carljmosca.repository.WidgetRepository;
import com.vaadin.annotations.Theme;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author moscac
 */
@SpringUI
@Theme("valo")
public class MainUI extends UI {

    private ComboBox cmbWidgets;
    private DemoAppData demoAppData;
    private VerticalLayout mainLayout;
    private BeanItemContainer<Widget> widgets;
    private FieldGroup fgWidget;
    private BeanItem<DemoAppData> biDemoAppData;
    @Autowired
    WidgetRepository widgetRepository;

    @Override
    protected void init(VaadinRequest request) {
        demoAppData = new DemoAppData();
        widgets = new BeanItemContainer<>(Widget.class);
        widgets.addAll(widgetRepository.findAll());
        addComponents();
        bind();
    }

    private void bind() {
        biDemoAppData = new BeanItem<>(demoAppData);
        fgWidget = new FieldGroup(biDemoAppData);             
        fgWidget.bind(cmbWidgets, "selectedWidget");
    }

    private void addComponents() {
        mainLayout = new VerticalLayout();
        addHeader();
        setContent(mainLayout);
    }

    private void addHeader() {
        HorizontalLayout hl = new HorizontalLayout();
        hl.setSpacing(true);
        cmbWidgets = new ComboBox();
        cmbWidgets.setContainerDataSource(widgets);
        cmbWidgets.setItemCaptionPropertyId("name");
        hl.addComponent(cmbWidgets);

        Button btnUpdate = new Button("Update", FontAwesome.ADJUST);
        btnUpdate.addClickListener((Button.ClickEvent event) -> {
            cmbWidgets.select(widgets.getIdByIndex(0));
        });
        hl.addComponent(btnUpdate);
        
        Button btnShow = new Button("Show", FontAwesome.DASHBOARD);
        btnShow.addClickListener((Button.ClickEvent event) -> {
            try {
                fgWidget.commit();
            } catch (FieldGroup.CommitException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(demoAppData.getSelectedWidget().getName());
        });
        hl.addComponent(btnShow);
        
        Button btnChange = new Button("Change", FontAwesome.REFRESH);
        btnChange.addClickListener((Button.ClickEvent event) -> {
            Widget widget = (Widget)biDemoAppData.getItemProperty("selectedWidget").getValue();
            widget.setName("test xxxx");
            System.out.println(demoAppData.getSelectedWidget().getName());
        });
        hl.addComponent(btnChange);

        mainLayout.addComponent(hl);
    }
}
