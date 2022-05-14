package model;

import java.util.ArrayList;

abstract class Medical_Staff extends Person {
    private Hospital hospital;
    private String Intership;

    private ArrayList<Appointment> MS_Appointments = new ArrayList<>();

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

    public ArrayList<Appointment> getMS_Appointments() {
        return MS_Appointments;
    }

    public void setMS_Appointments(ArrayList<Appointment> MS_Appointments) {
        this.MS_Appointments = MS_Appointments;
    }

    public void remove_appointment(Appointment appointment){
        MS_Appointments.removeIf(appointment1 -> appointment1.equals(appointment));
    }
}
