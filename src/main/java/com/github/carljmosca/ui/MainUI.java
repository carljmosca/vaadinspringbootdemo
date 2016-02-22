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
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author moscac
 */
@SpringUI
@Theme("valo")
public class MainUI extends UI {

    private DemoAppData demoAppData;
    private VerticalLayout mainLayout;
    private BeanItemContainer<Widget> widgets;
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
        
    }
    
    private void addComponents() {
        mainLayout = new VerticalLayout();
        addHeader();
        setContent(mainLayout);
    }
    
    private void addHeader() {
        HorizontalLayout hl = new HorizontalLayout();
        hl.setSpacing(true);
        ComboBox cmbWidgets = new ComboBox();
        cmbWidgets.setContainerDataSource(widgets);
        cmbWidgets.setItemCaptionPropertyId("name");
        hl.addComponent(cmbWidgets);    
        
        Button btnUpdate = new Button("Update", FontAwesome.ADJUST);
        btnUpdate.addClickListener((Button.ClickEvent event) -> {
            cmbWidgets.select(widgets.getIdByIndex(0));
        });
        hl.addComponent(btnUpdate);
                     
        mainLayout.addComponent(hl);
    }
}
