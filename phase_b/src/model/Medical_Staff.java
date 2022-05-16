package model;

import java.io.Serializable;
import java.util.ArrayList;

abstract class Medical_Staff extends Person implements Serializable {
    private Hospital hospital;
    private String Intership;


    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    String getIntership() {
        return this.Intership;
    }

    void setIntership(String value) {
        this.Intership = value;
    }


}