package model;

import java.util.Date;

public class Appointment {
    private DateClass Date;
    private Vaccine vaccine;
    private Citizen citizen;
    private Hospital hospital;
    private int AppointmentID;
    private Nurse nurse;
    private String time;// time format example 20:00;


    public Appointment(DateClass date, Citizen citizen, Hospital hospital, Nurse nurse,String time,Vaccine vaccine) {
        this.Date=date;
        this.citizen=citizen;
        this.hospital=hospital;
        this.time=time;
        this.nurse=nurse;
        this.vaccine=vaccine;
        this.AppointmentID=hashCode();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DateClass getDate() {
        return Date;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }


    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Hospital getHospital() {
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

    @Override
    public String toString() {
        return "Appointment{" +
                "\nDate : " + Date +
                " , " + time +
                "\n vaccine : " + vaccine.getName() +" , dose : "+ vaccine.getDose()+
                "\n citizen : " + citizen.Get_full_name() +
                "\n hospital : " + hospital.name +
                "\n AppointmentID : " + AppointmentID +
                "\n nurse : " + nurse.getFirst_name() +" "+nurse.getLast_name()+
                '\n' +
                '}';
    }
}
