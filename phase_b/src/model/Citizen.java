package model;

import java.util.Objects;

public class Citizen extends Person {
    private String AFM;  /*secondary key*/
    private String AMKA; /*primary key*/
    private String password;
    private boolean Vaccinated;
    public Appointment appointment;
    private int Phone_number;
    private Address adress;
    private Covid_19_certificate covid_19_certificate;

    /**
     * Create a citizen
     * @param first_name
     * @param last_name
     * @param born_date
     * @param AMKA
     */
    public Citizen(String first_name, String last_name, DateClass born_date, String AMKA) {
        setFirst_name(first_name);
        setLast_name(last_name);
        setBorn_date(born_date);
        this.AMKA=AMKA;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    public void setAFM(String AFM) {
        this.AFM = AFM;
    }
    public String getAFM() {
        return AFM;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getAMKA() {
        return AMKA;
    }

    public void setAMKA(String AMKA) {
        this.AMKA = AMKA;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    public Appointment getAppointment() {
        return appointment;
    }

    public void setVaccinated(boolean vaccinated) {
        Vaccinated = vaccinated;
    }
    public boolean IsVaccinated() {
        return this.Vaccinated;
    }
    int getPhone_number() {
        return this.Phone_number;
    }
    void setPhone_number(int value) {
        this.Phone_number=value;
    }


    public String Get_full_name() {
        return this.getFirst_name()+" "+this.getLast_name();
    }

    public void Set_new_password(String old_password,String new_password) {
        if(Objects.equals(old_password, this.password)){
            this.password=new_password;
        }
        else
            System.out.println("Wrong password");
    }

    public void Cancel_appointment(Appointment appointment) {

    }

    public void print_certificate(){

    }

    @Override
    public String toString() {
        return "Citizen{" +
                "Name=" + Get_full_name()+
                ", Born=" + getBorn_date()+
                ", AFM=" + AFM +
                ", AMKA=" + AMKA +
                ", Vaccinated=" + Vaccinated +
                ", appointment=" + appointment +
                ", Phone_number=" + Phone_number +
                ", covid_19_certificate=" + covid_19_certificate +
                '}';
    }
}
