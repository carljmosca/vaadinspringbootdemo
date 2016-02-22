/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author moscac
 */
@SpringUI
@Theme("valo")
public class MainUI extends UI {

    private VerticalLayout mainLayout;
    
    @Override
    protected void init(VaadinRequest request) {
        addComponents();
    }
    
    private void addComponents() {
        mainLayout = new VerticalLayout();
        addHeader();
        setContent(mainLayout);
    }
    
    private void addHeader() {
        HorizontalLayout hl = new HorizontalLayout();
        ComboBox cmbWidgets = new ComboBox("Widgets");
        hl.addComponent(cmbWidgets);        
        
        //, FontAwesome.BITBUCKET_SQUARE);
                
        mainLayout.addComponent(hl);
    }
}
