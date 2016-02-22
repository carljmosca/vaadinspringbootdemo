/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.data;

/**
 *
 * @author moscac
 */
public class DemoAppData {
    
    private Widget selectedWidget;
    private String name;

    public DemoAppData() {
        selectedWidget = new Widget();
    }
    
    public Widget getSelectedWidget() {
        return selectedWidget;
    }

    public void setSelectedWidget(Widget selectedWidget) {
        this.selectedWidget = selectedWidget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
}
