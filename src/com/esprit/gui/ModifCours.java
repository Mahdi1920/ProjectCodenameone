/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.esprit.entities.Cours;
import com.esprit.entities.Planning;
import com.esprit.services.ServiceCours;
import com.esprit.services.ServicePlanning;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mahdi
 */
public class ModifCours extends Form{
    private ComboBox<String> CoachComboBox;
    private ComboBox<String> PlanningComboBox ;
    private ComboBox<String> SallesComboBox;
    private ComboBox<String> CoursComboBox;
    private Picker HeurePicker;  
    private ComboBox<String> TypesComboBox;
    private ComboBox<String> NiveauComboBox;
    private Button btnAjout;
    private Button btnCancel;
    private Cours cour;
    private int coach;
    Date datep;
    private Form previousForm;
    SimpleDateFormat format = new  SimpleDateFormat("yyyy-MM-dd");
    
    public ModifCours(Cours c) {
        super("Modifier Cours", BoxLayout.y());
        cour = c;       
        OnGui();
        addActions();
    
    }

    private void OnGui(){
        ServicePlanning sp = new ServicePlanning();
        ServiceCours sc = new ServiceCours();
        List<Planning> plannings = sp.afficher();
        List<String> coaches = sc.getCoachs();
        CoachComboBox = new ComboBox<>();
        PlanningComboBox = new ComboBox<>();
        for(String c : coaches ){
            CoachComboBox.addItem(c);
        }
        for(Planning p : plannings){
             String dp = format.format(p.getDate());
            PlanningComboBox.addItem(dp);
        }
        SallesComboBox = new ComboBox<>("Cross Fit", "Dance", "Rpm");
        CoursComboBox = new ComboBox<>("Dance Orientale", "Yoga", "Burn Class", "Rpm", "Circuit Minceur", "Step", "Body Pump", "Abdo", "Pilates", "Grit", "Body Combat", "Body Fight", "Zumba");
        HeurePicker = new Picker();
        TypesComboBox = new ComboBox<>("En Ligne", "Presentiel");
        NiveauComboBox = new ComboBox<>("Easy", "Medium", "Difficult");
        HeurePicker.setType(Display.PICKER_TYPE_TIME);
        //HeurePicker.setTime(10*60);
       
        btnAjout = new Button("Add");
        this.addAll(CoachComboBox, PlanningComboBox,SallesComboBox,CoursComboBox,HeurePicker,TypesComboBox,NiveauComboBox,btnAjout,btnCancel);
    }

    private void addActions() {
        btnAjout.addActionListener(e -> {
//            String titre = tfTitre.getText();
//            String description = tfDescription.getText();
            
            // Update the blog with the new values
//            blog.setTitre(titre);
//            blog.setDescription(description);
//            blog.setIdBlog(idBlog);
//            blog.setIdUtilisateur(idu);
            
            
            ServiceCours su = new ServiceCours();
            boolean updateResult = su.modifier(cour);
            if (updateResult) {
                Dialog.show("Succès", "Le blog a été mis à jour avec succès.", "OK", null);
                // Refresh the home form to reflect the changes
                HomeForm homeForm = new HomeForm();
                homeForm.show();
            } else {
                Dialog.show("Erreur", "Échec de la mise à jour du blog.", "OK", null);
            }
        });

        btnCancel.addActionListener(e -> {
            // Simply go back to the home form without making any changes
              new HomeForm().show();
        });
    }
}
