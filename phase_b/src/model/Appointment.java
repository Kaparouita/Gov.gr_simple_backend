package model;

import java.util.Date;

public class Appointment {
    private Date Date;
    private Vaccine vaccine;
    private Citizen citizen;
    private String hospital;
    private int AppointmentID;
    private Nurse nurse;


    public Appointment(Date date, Citizen citizen, String hospital, Nurse nurse) {
    }

    public Date getDate() {
        return Date;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setDate(Date date, int time) {
        Date = date;
        date.setTime(time);
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getHospital() {
        return hospital;
    }

    public void setAppointmentID(int appointmentID) {
        AppointmentID = appointmentID;
    }

    public int getAppointmentID() {
        return AppointmentID;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Nurse getNurse() {
        return nurse;
    }
}
