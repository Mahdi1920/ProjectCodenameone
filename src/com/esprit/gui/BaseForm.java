/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.gui;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.Layout;

/**
 *
 * @author Mahdi
 */
public class BaseForm extends Form{
public BaseForm(String title, Layout l) {
        super(title, l);
        addActions();    
}

    
private void addActions() {
        getToolbar().addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {
            new AfficheCoursForm(this).show();
        });
        getToolbar().addMaterialCommandToSideMenu("Add", FontImage.MATERIAL_ADD, e -> {
            new AjoutCoursForm(this).show();
        });
    }
}