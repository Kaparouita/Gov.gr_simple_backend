package model;

import model.Appointment;

abstract class Medical_Staff extends Person {
    private String Hospital_name;
    private String Department_name;
    private String Intership;
    private Appointment[] MS_Appointments;


    public String Get_hospital_name() {
        return this.Hospital_name;
    }

    public String Get_department_name() {
        return this.Department_name;
    }


    String getIntership() {
        return this.Intership;
    }

    void setIntership(String value) {
        this.Intership = value;
    }

    Appointment[] getMS_Appointments() {
        return this.MS_Appointments;
    }
    void setMS_Appointments(Appointment[] value) {
        this.MS_Appointments = value;
    }



}
