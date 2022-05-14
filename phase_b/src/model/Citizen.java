package model;

import java.util.Objects;

public class Citizen extends Person {
    private String AFM;  /*secondary key*/
    private String AMKA; /*primary key*/
    private String password;
    private boolean Vaccinated;
    private Appointment appointment;
    private Address adress;
    private Covid_19_certificate covid_19_certificate;
    private int curr_dose;

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
        setCurr_dose(1);
    }

    public int getCurr_dose() {
        return curr_dose;
    }

    public void setCurr_dose(int curr_dose) {
        this.curr_dose = curr_dose;
    }

    public Address getAdress() {
        return adress;
    }

    public Covid_19_certificate getCovid_19_certificate() {
        return covid_19_certificate;
    }

    public void setCovid_19_certificate(Covid_19_certificate covid_19_certificate) {
        this.covid_19_certificate = covid_19_certificate;
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

    public void print_certificate(){

    }

    @Override
    public String toString() {
        return
                "Name=" + Get_full_name()+
                "\n Born=" + getBorn_date()+
                "\n AFM=" + AFM +
                "\n AMKA=" + AMKA +
                "\n Phone_number=" + getPhone_number() ;
    }
}
