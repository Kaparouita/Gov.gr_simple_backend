import java.util.Date;

public class Citizen extends Person {
    private String AFM;
    private String password;
    private int UserID;
    private boolean Vaccinated;
    public Appointment appointment;
    private int Phone_number;

    public Citizen(String first_name, String last_name, Date born_date, String AFM) {
    }

    public String Get_full_name() {
        return this.getFirst_name()+" "+this.getLast_name();
    }
    public int Get_userID() {
        return this.UserID;
    }
    public String Get_AFM() {
        return this.AFM;
    }

    public void Set_new_password(int old_password) {
    }

    public void Set_phone(int number) {
    }

    public boolean IsVaccinated() {
        return this.Vaccinated;
    }

    public void Set_Vaccinated(boolean vaccinated) {
    }

    public void Set_appointment(Appointment appointment) {
    }

    public void Cancel_appointment(Appointment appointment) {
    }

    public Appointment Get_Appointment() {
        return this.appointment;
    }


    int getPhone_number() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.Phone_number;
    }

    void setPhone_number(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.Phone_number = value;
    }

}
