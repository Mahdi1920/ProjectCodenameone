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
public class Planning {

    private int idPlanning;
    private Date date;

    public Planning(int idPlanning, Date date) {
        this.idPlanning = idPlanning;
        this.date = date;
    }

    public Planning(Date date) {
        this.date = date;
    }

    public Planning() {
    }

    public int getIdPlanning() {
        return idPlanning;
    }

    public Date getDate() {
        return date;
    }

    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Planning{" + "idPlanning=" + idPlanning + ", date=" + date + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(this == obj)
            return true;
        if(this.getClass() != obj.getClass())
            return false;
        
        final Planning other = (Planning) obj;
        if(!this.date.equals(other.date)){
            return  false;
        }
        
        return true;
    }
}
