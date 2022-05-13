package model;

import java.util.ArrayList;


public class System_Admin extends Person {
    private int AdminID;
    private Doctor[] Doctors;
    private ArrayList<Citizen> Citizens = new ArrayList<Citizen>();
    private ArrayList<Nurse> Nurses = new ArrayList<Nurse>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    ArrayList<DateClass> Available_dates = new ArrayList<>();

    public void Add_Citizen(Citizen citizen) {
        Citizens.add(citizen);
    }

    public void Add_doctor(Doctor doctor) {
    }

    /**
     * add a nurse to the system
     * @param nurse The nurse
     */
    public void Add_nurse(Nurse nurse) {
        for (Nurse nurse1 : Nurses) {
            if (nurse1.Get_nurseID() == nurse.Get_nurseID()) {
                System.out.println("Nurse already in the system");
                return;
            }
        }
        Nurses.add(nurse);
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public ArrayList<Nurse> getNurses() {
        return Nurses;
    }

    /**
     * initialize available dates to book appointments
     */
    public void init_available_dates() {
        ArrayList<String> time = new ArrayList<>();
        for (int i = 8; i < 20; i++) {
            for (int j = 0; j < 60; ) {
                if (j == 0)
                    time.add(i + ":0" + j);
                else
                    time.add(i + ":" + j);
                j = j + 20;
            }
        }
        for (int i = 1; i < 32; i++) {
            for (int j = 0; j < time.size(); j++) {
                DateClass init_date = new DateClass(i, 6, 2000);
                init_date.setTime(time.get(j));
                Available_dates.add(init_date);
            }
        }
    }

    public ArrayList<DateClass> getAvailable_dates() {
        return Available_dates;
    }

    /**
     * Remove a citizen from the database
     * @param citizen
     */
    public void Delete_Citizen(Citizen citizen) {
        Citizens.remove(citizen);
    }

    /**
     * Remove a nurse from the database
     * @param nurse
     */
    public void Delete_nurse(Nurse nurse) {
        Nurses.remove(nurse);
    }
    public void Delete_appointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public void Delete_doctor(Doctor doctor) {
    }

    public void Get_doctor(Doctor doctor) {
    }

    public System_Admin(int admin_id) {
        this.AdminID=admin_id;
    }

    /**
     * Print citizens data
     */
    public void getCitizen_Data() {
        for (Citizen citizen : Citizens) {
            System.out.println(citizen + " ,");
        }
    }

    /**
     * Print all Appointments in the database
     */
    public void getAppointments_Data() {
        for (Appointment appointment : appointments) {
            System.out.println(appointment + " ,");
        }
    }
    /**
     * Print Nurses data
     */
    public void getNurses_Data() {
        for (Nurse nurse : Nurses) {
            System.out.println(nurse + " ,");
        }
    }
    /**
     * add new user to the database
     * If AMKA is the same (primary key) dont register
     *
     * @param password must be at least 6 char
     */
    public void register(Citizen citizen, String password) {
        boolean flag = false;
        for (Citizen value : Citizens) {
            if (value.getAMKA().equals(citizen.getAMKA())) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            if (password.length() >= 6) {
                Add_Citizen(citizen);
                citizen.setPassword(password);
            } else
                System.out.println("Password must be at least 6 char");
        } else
            System.out.println("Already registered");
    }

    /**
     * Login to the system
     * to login ginete me AMKA kai password
     * returns true if login succeed /returns false otherwise
     * @param password
     * @param AMKA
     */
    public boolean Login(String AMKA, String password) {
        for (Citizen value : Citizens) {
            if (value.getAMKA().equals(AMKA)) {
                if (value.getPassword().equals(password)) {
                    /*login succed*/
                    System.out.println("login successfully");
                    return true;
                } else {
                    System.out.println("Wrong password");
                    return false;
                }
            }
        }
        System.out.println("no citizen with that AMKA");
        return false;
    }
}

