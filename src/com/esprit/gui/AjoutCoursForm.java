/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.gui;

import com.codename1.l10n.ParseException;
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
import java.util.Map;





/**
 *
 * @author abdel
 */
public class AjoutCoursForm extends BaseForm {

    private ComboBox<String> CoachComboBox;
    private ComboBox<String> PlanningComboBox ;
    private ComboBox<String> SallesComboBox;
    private ComboBox<String> CoursComboBox;
    private Picker HeurePicker;  
    private ComboBox<String> TypesComboBox;
    private ComboBox<String> NiveauComboBox;
    private Button btnAjout;
   // private Cours c;
    private int coach;
    Date datep;
    private Form previousForm;
    SimpleDateFormat format = new  SimpleDateFormat("yyyy-MM-dd");
    //SimpleDateFormattimeFormatter = new SimpleDateFormat("h:mm a");
    public AjoutCoursForm(Form f) {
        super("Ajout", BoxLayout.y());
        previousForm = f;
        OnGui();
        addActions();
    }

    private void OnGui() {
                   
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
        this.addAll(CoachComboBox, PlanningComboBox,SallesComboBox,CoursComboBox,HeurePicker,TypesComboBox,NiveauComboBox,btnAjout);
    }

    private void addActions() {
        btnAjout.addActionListener((evt) -> {
            if (CoachComboBox.getSelectedItem().isEmpty() || CoursComboBox.getSelectedItem().isEmpty()) {
                Dialog.show("Alerte", "Veillez remplir tous les champs", "OK", null);
            } 
            else {
                ServiceCours sc = new ServiceCours();
                    for (Map.Entry ele : ServiceCours.resultC.entrySet()) {
                        for(Map<String, Object> obj : (List<Map<String, Object>>)ServiceCours.resultC.get("root")){
                            if ((obj.get("Prenom").toString()+' '+obj.get("Nom").toString()).equals(CoachComboBox.getSelectedItem())) {
                                coach = (int) Float.parseFloat(obj.get("id").toString());
                                try {
                                    datep =format.parse(PlanningComboBox.getSelectedItem());
                                } catch (java.text.ParseException ex) {
                                    System.out.println(ex.getMessage());
                                }
                                System.out.println("date before format : " + datep);
                                //c = new Cours(coach,NiveauComboBox.getSelectedItem(),TypesComboBox.getSelectedItem(),CoursComboBox.getSelectedItem(),String.valueOf(HeurePicker.getTime()),SallesComboBox.getSelectedItem(),datep);
                            }
                        }
                    }
                    if (sc.ajouter(new Cours(coach,NiveauComboBox.getSelectedItem(),TypesComboBox.getSelectedItem(),CoursComboBox.getSelectedItem(),String.valueOf(HeurePicker.getTime()),SallesComboBox.getSelectedItem(),datep))) {    
                        System.out.println(new Cours(coach,NiveauComboBox.getSelectedItem(),TypesComboBox.getSelectedItem(),CoursComboBox.getSelectedItem(),String.valueOf(HeurePicker.getTime()),SallesComboBox.getSelectedItem(),datep));
                        Dialog.show("SUCCESS", "Cours ajoutée !", "OK", null);
                    } 
                    else {
                            Dialog.show("ERROR", "Erreur serveur", "OK", null);
                        }
            }
        });
        this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
            previousForm.showBack();
        });
        
    }
    
    
}
