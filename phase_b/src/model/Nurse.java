package model;

import model.Citizen;
import model.Doctor;
import model.Medical_Staff;

import java.util.Date;

public class Nurse extends Medical_Staff {
    private final int nurseID;
    private Doctor Working_for;
    private int appointments_count;

    public Nurse(String first_name,String last_name, DateClass born_date,Hospital hospital) {
        setFirst_name(first_name);
        setLast_name(last_name);
        setBorn_date(born_date);
        setHospital(hospital);
        this.nurseID=hashCode();
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

    public void Vaccinate_citizen(Citizen citizen, Vaccine vaccine) {
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
