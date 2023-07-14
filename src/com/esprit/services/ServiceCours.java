/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.esprit.entities.Cours;
import com.esprit.utils.Statics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





/**
 *
 * @author Mahdi
 */
public class ServiceCours implements IService<Cours>{
    Map<Integer, String> map = new HashMap();
    List<String> coachs;
    private boolean responseResult;
    private List<Cours> cours;
    public static Map<String, Object> resultC;
    private final String URI = Statics.BASE_URL + "/cours/";
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDate;
    public ServiceCours() {
        cours = new ArrayList();
        coachs = new ArrayList();
    }
    
    @Override
    public boolean ajouter(Cours c) {
        ConnectionRequest request = new ConnectionRequest();
        
        request.setUrl(URI);
        request.setHttpMethod("POST");  
        
//        System.out.println(c.getDatePlanning());
        
        formattedDate = format.format(c.getDatePlanning());
        System.out.println("date after format: " + formattedDate);

        request.addArgument("Coach", String.valueOf(c.getIdCoach()));
        request.addArgument("niveau", c.getNiveau());
        request.addArgument("typeCours",c.getTypeCours());
        request.addArgument("nomCours",c.getNomCours());
        request.addArgument("heure",c.getHeure());
        request.addArgument("salle",c.getSalle());
        request.addArgument("datePlanning", formattedDate);
        System.out.println("cours :"+c);
        request.addResponseListener((evt) -> {
            responseResult = request.getResponseCode() == 201; // Code HTTP 201 OK
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;    
    }

    @Override
    public boolean modifier(Cours t) {
        return true;
    }

    @Override
    public boolean supprimer(Cours t) {
return true;    }

    @Override
    public List<Cours> afficher() {
        ConnectionRequest request = new ConnectionRequest();
        
        request.setUrl(URI);
        request.setHttpMethod("GET");
        
        
        request.addResponseListener((evt) -> {
            try {
                InputStreamReader jsonText = new InputStreamReader(new ByteArrayInputStream(request.getResponseData()), "UTF-8");
                Map<String, Object> result = new JSONParser().parseJSON(jsonText);
                List<Map<String, Object>> list = (List<Map<String, Object>>) result.get("root");

                for (Map<String, Object> obj : list) {
                    int id = (int) Float.parseFloat(obj.get("idCours").toString());
                    int coach =(int) Float.parseFloat(obj.get("Coach").toString());
                    String nomCoach = obj.get("Prenom").toString() + ' ' + obj.get("Nom").toString();
                    String nomCours = obj.get("nomCours").toString();
                    String typeCours = obj.get("typeCours").toString();
                    String salle = obj.get("salle").toString();
                    String niveau = obj.get("niveau").toString();
                    String heure = obj.get("heure").toString();
                    
                    Date datePlanning=null;
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        //String fd =format.format(obj.get("datePlanning"));
                        datePlanning = format.parse(obj.get("datePlanning").toString());
                    } catch (ParseException ex) {
                        System.out.println(ex.getMessage());
                    }
                    cours.add(new Cours(id,coach,niveau ,typeCours,nomCoach, nomCours,heure,salle,datePlanning));
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } 
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
        return cours;
    }
    
 public List<String>  getCoachs(){
     
     ConnectionRequest request = new ConnectionRequest();
        
        request.setUrl(URI+"users");
        request.setHttpMethod("GET");

        request.addResponseListener((evt) -> {
            try {
                InputStreamReader jsonText = new InputStreamReader(new ByteArrayInputStream(request.getResponseData()), "UTF-8");
                 resultC = new JSONParser().parseJSON(jsonText);
                List<Map<String, Object>> list = (List<Map<String, Object>>) resultC.get("root");

                for (Map<String, Object> obj : list) {
                    int id = (int) Float.parseFloat(obj.get("id").toString());
                    String nomCoach = obj.get("Prenom").toString() + ' ' + obj.get("Nom").toString();
                    
                    coachs.add(nomCoach);
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
return coachs;
 }
}
