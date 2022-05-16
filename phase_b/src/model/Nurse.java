package model;

import model.Citizen;
import model.Doctor;
import model.Medical_Staff;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Nurse extends Medical_Staff implements Serializable {
    private  int nurseID;
    private Doctor Working_for;
    private int appointments_count;
    private String password;
    private ArrayList<Appointment> MS_Appointments = new ArrayList<>();

    public Nurse(String first_name,String last_name, DateClass born_date,Hospital hospital) {
        setFirst_name(first_name);
        setLast_name(last_name);
        setBorn_date(born_date);
        setHospital(hospital);
        this.nurseID=hashCode();
    }

    public void setNurseID(int nurseID) {
        this.nurseID = nurseID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getAppointments_count() {
        return appointments_count;
    }

    public void setAppointments_count(int appointments_count) {
        this.appointments_count = appointments_count;
    }

    public int Get_nurseID() {
        return this.nurseID;
    }

    public Doctor Get_working_for() {
        return this.Working_for;
    }

    public void Set_working_for(Doctor p1) {
        Working_for=p1;
    }

    public ArrayList<Appointment> getMS_Appointments() {
        return MS_Appointments;
    }

    public void setMS_Appointments(ArrayList<Appointment> MS_Appointments) {
        this.MS_Appointments = MS_Appointments;
    }

    public void remove_appointment(Appointment appointment) {
        MS_Appointments.removeIf(appointment1 -> appointment1.equals(appointment));
    }

    /**
     * after someone is vaccinated confirmed it
     *
     */
    public void Confirm_vaccination(){

    }

    @Override
    public String toString() {
        return "Nurse{" +
                "First name  = " + getFirst_name()+
                ", Last name = "  + getLast_name() +
                ", nurseID = " + nurseID +
                ", Working_for = " + Working_for +
                ", Working_at = "+ getHospital().name +
                '}';
    }
}
