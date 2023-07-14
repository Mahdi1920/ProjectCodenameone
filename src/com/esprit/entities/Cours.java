/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.util.Date;



/**
 *
 * @author Mahdi
 */
public class Cours {
    private int idCours;
    private int idCoach;
    private String niveau;
    private String typeCours;
    private String NomCoache;
    private String nomCours;
    private String heure;
    private String salle;
    private Date datePlanning;
    
    public Cours() {
    }

    public Cours(int idCoach, String niveau, String typeCours, String nomCours, String heure, String salle, Date datePlanning) {
        this.idCoach = idCoach;
        this.niveau = niveau;
        this.typeCours = typeCours;
        this.nomCours = nomCours;
        this.heure = heure;
        this.salle = salle;
        this.datePlanning = datePlanning;
    }

    

    public Cours(int idCours, int idCoach, String niveau, String typeCours, String nomCours, String heure, String salle, Date datePlanning) {
        this.idCours = idCours;
        this.idCoach = idCoach;
        this.niveau = niveau;
        this.typeCours = typeCours;
        this.nomCours = nomCours;
        this.heure = heure;
        this.salle = salle;
        this.datePlanning = datePlanning;
    }

    public Cours(int idCours, String niveau, String typeCours, String NomCoache, String nomCours, String heure, String salle) {
        this.idCours = idCours;
        this.niveau = niveau;
        this.typeCours = typeCours;
        this.NomCoache = NomCoache;
        this.nomCours = nomCours;
        this.heure = heure;
        this.salle = salle;
    }

    public Cours(int idCoach, String niveau, String typeCours, String nomCours, String heure, String salle) {
        this.idCoach = idCoach;
        this.niveau = niveau;
        this.typeCours = typeCours;
        this.nomCours = nomCours;
        this.heure = heure;
        this.salle = salle;
    }
    
   

    public Cours(int idCours, int idCoach, String niveau, String typeCours, String NomCoache, String nomCours, String heure,String salle, Date datePlanning) {
        this.idCours = idCours;
        this.idCoach = idCoach;
        this.niveau = niveau;
        this.typeCours = typeCours;
        this.NomCoache = NomCoache;
        this.nomCours = nomCours;
        this.heure = heure;
        this.salle = salle;
        this.datePlanning = datePlanning;
    }
    public Cours(int idCoach, String niveau, String typeCours, String NomCoache, String nomCours, String heure,String salle, Date datePlanning) {
        this.idCoach = idCoach;
        this.niveau = niveau;
        this.typeCours = typeCours;
        this.NomCoache = NomCoache;
        this.nomCours = nomCours;
        this.heure = heure;
        this.salle = salle;
        this.datePlanning = datePlanning;
    }
    public int getIdCoach() {
        return idCoach;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setIdCoach(int idCoach) {
        this.idCoach = idCoach;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getTypeCours() {
        return typeCours;
    }

    public void setTypeCours(String typeCours) {
        this.typeCours = typeCours;
    }

    public String getNomCoache() {
        return NomCoache;
    }

    public void setNomCoache(String NomCoache) {
        this.NomCoache = NomCoache;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public Date getDatePlanning() {
        return datePlanning;
    }

    public void setDatePlanning(Date datePlanning) {
        this.datePlanning = datePlanning;
    }
//    public boolean equals(Object obj) {
//        if(obj == null)
//            return false;
//        if(this == obj)
//            return true;
//        if(this.getClass() != obj.getClass())
//            return false;
//
//        final Cours other = (Cours)obj;
//        if(!(this.idCoach==other.getIdCoach()))
//            return false;
//        if(!(this.nomCours.equals(other.getNomCours())))
//            return false;
//        if(!(this.niveau.equals(other.getNiveau())))
//            return false;
//        if(!(this.typeCours.equals(other.getTypeCours())))
//            return false;
//        if(!(this.salle.equals(other.getSalle())))
//            return false;
//        if(!(this.heure.equals(other.getHeure())))
//            return false;
//        if(!(this.datePlanning==other.getDatePlanning()))
//            return false;
//        
//        return true;
//    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(this == obj)
            return true;
        if(this.getClass() != obj.getClass())
            return false;
        
        final Cours other = (Cours) obj;
        if(this.datePlanning.equals(other.datePlanning)){
            if ( this.idCoach!=other.idCoach || !this.heure.equals(other.heure) || !this.salle.equals(other.salle))  {
                return false;
            }
        }
        
//        if (!Objects.equals(this.niveau, other.niveau)) {
//            return false;
//        }
//        if (!Objects.equals(this.typeCours, other.typeCours)) {
//            return false;
//        }
//        if (!Objects.equals(this.nomCours, other.nomCours)) {
//            return false;
//        }
//        if (!Objects.equals(this.heure, other.heure)) {
//            return false;
//        }
//        if (!Objects.equals(this.salle, other.salle)) {
//            return false;
//        }
//        if (!Objects.equals(this.datePlanning, other.datePlanning));
//            return false;
            
        return true;
    }
    
    @Override
    public String toString() {
        return "Cours{" + "idCours=" + idCours + ", idCoach=" + idCoach + ", niveau=" + niveau + ", typeCours=" + typeCours + ", NomCoache=" + NomCoache + ", nomCours=" + nomCours + ", heure=" + heure + ", salle=" + salle + ", datePlanning=" + datePlanning + '}';
    }
}