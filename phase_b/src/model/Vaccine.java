package model;

import model.Citizen;
import model.Nurse;

import java.util.Date;

public class Vaccine {
    private String Name;
    private int dose;
    private Citizen Person;
    private model.Nurse Nurse;
    private Date Date;
    private int vaccine_ID;

    public void Vaccinate(Citizen citizen, Nurse nurse, Date date) {
    }

    public Vaccine(String vaccine_name) {
    }
    public void setDose(int dose) {
        this.dose = dose;
    }
    public int getDose() {
        return dose;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public java.util.Date getDate() {
        return Date;
    }


    public int getVaccine_ID() {
        return vaccine_ID;
    }

    public void setVaccine_ID(int vaccine_ID) {
        this.vaccine_ID = vaccine_ID;
    }
}
