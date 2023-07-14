/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.esprit.entities.Cours;
import com.esprit.entities.Planning;
import com.esprit.utils.Statics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mahdi
 */
public class ServicePlanning implements IService<Planning>{
private boolean responseResult;
    private List<Planning> plannings;
    
    private final String URI = Statics.BASE_URL + "/planning/";

    public ServicePlanning() {
        plannings = new ArrayList();
    }
    @Override
    public boolean ajouter(Planning t) {
        return true;
    }

    @Override
    public boolean modifier(Planning t) {
        return true;
    }

    @Override
    public boolean supprimer(Planning t) {
        return true;
    }

    @Override
    public List<Planning> afficher() {
        ConnectionRequest request = new ConnectionRequest();
        
        request.setUrl(URI);
        request.setHttpMethod("GET");

        request.addResponseListener((evt) -> {
            try {
                InputStreamReader jsonText = new InputStreamReader(new ByteArrayInputStream(request.getResponseData()), "UTF-8");
                Map<String, Object> result = new JSONParser().parseJSON(jsonText);
                List<Map<String, Object>> list = (List<Map<String, Object>>) result.get("root");

                for (Map<String, Object> obj : list) {
                    int id = (int) Float.parseFloat(obj.get("idPlanning").toString());
                    SimpleDateFormat format = new  SimpleDateFormat("yyyy-MM-dd");
                    Date datePlanning = format.parse(format.format(obj.get("date")));
                    plannings.add(new Planning(id,datePlanning));
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (ParseException ex) {
System.out.println(ex.getMessage());            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
                            System.out.println(plannings);

        return plannings;
    }
    
}
