/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author abdel
 */
public class HomeForm extends BaseForm {
    
    private Button btnAddCours;
    private Button btnShowCours;

    public HomeForm() {
        super("Home", BoxLayout.y());
        OnGui();
        addActions();
    }
    
    private void OnGui() {
       // btnAddCours = new Button("Ajouter");
        //btnShowCours = new Button("Afficher");
        //this.addAll(new Label("Choisissez une option :"), btnAddCours, btnShowCours);
        new AfficheCoursForm(this).show();
    }
    
    private void addActions() {
//        btnAddCours.addActionListener((evt) -> {
//            new AjoutCoursForm(this).show();
//        });
//        btnShowCours.addActionListener((evt) -> {
//            new AfficheCoursForm(this).show();
//        });
    }
    
}
