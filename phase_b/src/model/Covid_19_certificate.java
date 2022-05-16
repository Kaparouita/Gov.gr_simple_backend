package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Covid_19_certificate implements Serializable {
    private Citizen citizen;
    private Vaccine vaccine;
    private int certificate_ID; //primary_key
    private Medical_Staff medical_staff;
    private DateClass date;

    /**
     * Create a covid_19 certificate by using
     * an appointment's info
     *
     * @param appointment
     */
    public Covid_19_certificate(Appointment appointment) {
        this.citizen = appointment.getCitizen();
        this.vaccine = appointment.getVaccine();
        this.date = appointment.getDate();
        this.medical_staff = appointment.getNurse();
        this.certificate_ID = hashCode();
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public void setDate(DateClass date) {
        this.date = date;
    }

    public void setCertificate_ID(int certificate_ID) {
        this.certificate_ID = certificate_ID;
    }

    public void setMedical_staff(Medical_Staff medical_staff) {
        this.medical_staff = medical_staff;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public DateClass getDate() {
        return date;
    }

    public int getCertificate_ID() {
        return certificate_ID;
    }

    public Medical_Staff getMedical_staff() {
        return medical_staff;
    }

    /**
     * prints this certificate
     */
    public String print_certificate() {
        return "Covid_19_certificate\n" +
                "Certificate barcode : " + certificate_ID +
                "\nName : " + citizen.Get_full_name() +
                "\nVaccine : " + vaccine.getName() +
                "\nDose : " + vaccine.getDose() +
                "\nDate : " + date + " , time : " + date.getTime() +
                "\nNurse : " + getMedical_staff().getFirst_name() + " " + getMedical_staff().getLast_name()
                ;
    }

    public void print_certificate_to_txt() throws IOException {
        try {
            File myObj = new File(citizen.getFirst_name() + "_" + citizen.getLast_name() + "_covid-19_certificate.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter(citizen.getFirst_name() + "_" + citizen.getLast_name() +
                    "_covid-19_certificate.txt");
            myWriter.write(print_certificate());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
