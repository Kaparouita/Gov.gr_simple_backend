import java.util.Date;

public class Nurse extends Medical_Staff {
    private int nurseID;
    private Doctor Working_for;

    public Nurse(String name, Date born_date) {
        setFirst_name(name);
        setBorn_date(born_date);
    }


    public int Get_nurseID() {
        return this.nurseID;
    }

    public Doctor Get_working_for() {
        return this.Working_for;
    }

    public void Set_working_for(Doctor p1) {
    }

    public void Vaccinate_citizen(Citizen citizen, Vaccine vaccine) {
    }

}
