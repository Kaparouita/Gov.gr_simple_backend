public class Covid_19_certificate {
    private Person person;
    private Vaccine vaccine;
    private int certificate_ID; //primary_key
    private Medical_Staff medical_staff;
    private Date date;


    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCertificate_ID(int certificate_ID) {
        this.certificate_ID = certificate_ID;
    }

    public void setMedical_staff(Medical_Staff medical_staff) {
        this.medical_staff = medical_staff;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public Date getDate() {
        return date;
    }

    public int getCertificate_ID() {
        return certificate_ID;
    }

    public Medical_Staff getMedical_staff() {
        return medical_staff;
    }

    public Person getPerson() {
        return person;
    }
}
