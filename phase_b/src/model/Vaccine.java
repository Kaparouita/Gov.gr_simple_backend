package model;

import model.Citizen;
import model.Nurse;

import java.util.Date;

public class Vaccine {
    private String Name;
    private int dose;
    private int vaccine_ID;

    /**
     * Create a vaccine
     * @param vaccine_name Johnson / Pfizer
     * @param dose first/second etc
     */
    public Vaccine(String vaccine_name,int dose) {
        this.Name=vaccine_name;
        this.dose=dose;
        vaccine_ID=hashCode();
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

    public int getVaccine_ID() {
        return vaccine_ID;
    }

    public void setVaccine_ID(int vaccine_ID) {
        this.vaccine_ID = vaccine_ID;
    }
}
