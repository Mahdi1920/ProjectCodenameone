/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.gui;

import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.entities.Cours;
import com.esprit.services.ServiceCours;
import java.util.List;

/**
 *
 * @author abdel
 */
public class AfficheCoursForm extends BaseForm {
    private Form previousForm;
    
    public AfficheCoursForm(Form f) {
        super("Affichage", BoxLayout.y());
        previousForm = f;
        OnGui();
        addActions();
    }

    private void OnGui() {
        ServiceCours sc = new ServiceCours();
        List<Cours> lcours = sc.afficher();
        for (Cours c : lcours) {
                addItem(c);  
        }
        }

    public void addItem(Cours c) {
        Container c1 = new Container(BoxLayout.x());

        Container c2 = new Container(BoxLayout.y());
        Label nomCours = new Label("Cours : " +c.getNomCours());
        Label nomCoach = new Label("Coach :" + c.getNomCoache());
        Label Heure = new Label("Heure :" + c.getHeure());
        Label Type = new Label(c.getTypeCours());
        Label salle = new Label(c.getSalle());
        Label niveau = new Label(c.getNiveau());
        Label heure = new Label(c.getHeure());
        Label datePlanning = new Label(c.getDatePlanning().toString());

        
////        c1.addAll(nomCours, nomCoach,Type,salle,niveau,heure,datePlanning);
        c2.addAll(nomCours, nomCoach,heure);

        nomCours.addPointerPressedListener(p -> {
            Dialog.show("Cours", nomCoach.getText() + " \n " + nomCours.getText(),"OK", null);
        });
        c2.setLeadComponent(nomCours);
        c1.addAll(c2);

        add(c1);
    }
    private void addActions() {
        this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
            previousForm.showBack();
        });
    }
}
