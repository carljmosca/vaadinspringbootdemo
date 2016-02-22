/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.repository;

import com.github.carljmosca.data.Widget;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author moscac
 */
@Component
public class WidgetRepository {
   
    public List<Widget> findAll() {
        List<Widget> widgets = new ArrayList<>();
        widgets.add(new Widget(new Date().getTime(), "test", "test description"));
        widgets.add(new Widget(new Date().getTime(), "test 2", "test asd description"));
        widgets.add(new Widget(new Date().getTime(), "test 3", "test asddd description"));
        widgets.add(new Widget(new Date().getTime(), "test 4", "test asdd description"));
        return widgets;
    }
}
