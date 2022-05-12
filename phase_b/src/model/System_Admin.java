package model;

import java.util.ArrayList;


public class System_Admin extends Person {
    private int AdminID;
    private Doctor[] Doctors;
    private ArrayList<Citizen> Citizens = new ArrayList<Citizen>();
    private ArrayList<Nurse> Nurses = new ArrayList<Nurse>();

    public void Add_Citizen(Citizen citizen) {
        Citizens.add(citizen);
    }

    public void Add_doctor(Doctor doctor) {
    }

    /**
     * add a nurse to the system
     * @param nurse The nurse
     * @param hospital Hospital working for
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

    public void Delete_Citizen(Citizen citizen) {
    }

    public void Delete_nurse(Nurse nurse) {
    }

    public void Delete_doctor(Doctor doctor) {
    }

    public void Get_doctor(Doctor doctor) {
    }

    public System_Admin(int admin_id) {
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
     *
     * @param password
     * @param AMKA
     */
    public void Login(String AMKA, String password) {
        for (Citizen value : Citizens) {
            if (value.getAMKA().equals(AMKA)) {
                if (value.getPassword().equals(password)) {
                    /*login succed*/
                    System.out.println("login successfully");
                    return;
                } else {
                    System.out.println("Wrong password");
                    return;
                }
            }
        }
        System.out.println("no citizen with that AMKA");
    }
}
