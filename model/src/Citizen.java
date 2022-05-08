import java.util.Date;
import java.util.Objects;

public class Citizen extends Person {
    private int AFM;
    private String password;
    private int UserID;
    private boolean Vaccinated;
    public Appointment appointment;
    private int Phone_number;
    private Covid_19_certificate covid_19_certificate;

    public Citizen(String first_name, String last_name, Date born_date, int afm) {
        setFirst_name(first_name);
        setLast_name(last_name);
        setBorn_date(born_date);
        this.AFM=afm;
    }

    public void setAFM(int AFM) {
        this.AFM = AFM;
    }
    public int getAFM() {
        return AFM;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    public Appointment getAppointment() {
        return appointment;
    }
    public void setUserID(int userID) {
        UserID = userID;
    }
    public int getUserID() {
        return UserID;
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

}
