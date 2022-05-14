package model;

import java.util.ArrayList;
import java.util.Objects;


public class System_Admin extends Person {
    private int AdminID;
    private Doctor[] Doctors;
    private ArrayList<Citizen> Citizens = new ArrayList<Citizen>();
    private ArrayList<Nurse> Nurses = new ArrayList<Nurse>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private ArrayList<Appointment> DONE_appointments = new ArrayList<>();
    ArrayList<DateClass> Available_dates = new ArrayList<>();

    public void Add_Citizen(Citizen citizen) {
        Citizens.add(citizen);
    }

    public void Add_doctor(Doctor doctor) {
    }

    /**
     * add a nurse to the system
     *
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

    public ArrayList<Appointment> getDONE_appointments() {
        return DONE_appointments;
    }

    public void setDONE_appointments(ArrayList<Appointment> DONE_appointments) {
        this.DONE_appointments = DONE_appointments;
    }

    public ArrayList<Nurse> getNurses() {
        return Nurses;
    }

    /**
     * initialize available dates to book appointments
     */
    public void init_available_dates(int curr_day, int curr_month) {
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
                DateClass init_date = new DateClass(curr_day, curr_month, 2000);
                init_date.setTime(time.get(j));
                Available_dates.add(init_date);
            }
            curr_day++;
            if (curr_day == 31) {
                curr_day = 1;
                curr_month++;
            }

        }
    }

    public ArrayList<DateClass> getAvailable_dates() {
        return Available_dates;
    }

    /**
     * Remove a citizen from the database
     *
     * @param citizen
     */
    public void Delete_Citizen(Citizen citizen) {
        Citizens.remove(citizen);
    }

    /**
     * Remove a nurse from the database
     *
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
        this.AdminID = admin_id;
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
     * Print all Available dates in the database
     */
    public void getAvailable_Dates_Data() {
        for (DateClass dateClass : Available_dates) {
            System.out.println(dateClass + " , " + dateClass.getTime());
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

    public void confirm_vaccination(int AppointmentID){
        for(Appointment appointment1 : appointments)
        {
            if(appointment1.getAppointmentID()==AppointmentID){
                Citizen citizen=appointment1.getCitizen();
                Nurse nurse=appointment1.getNurse();

                citizen.setCurr_dose(appointment1.getCitizen().getCurr_dose()+1);/*update dose*/
                citizen.setCovid_19_certificate(new Covid_19_certificate(appointment1));/*update certificate*/
                citizen.setVaccinated(true);/*set vaccinated true*/
                citizen.setAppointment(null);/*remove appointment from citizen*/

                nurse.remove_appointment(appointment1); /*remove from nurse database*/
                DONE_appointments.add(appointment1); /*add to done database*/
                appointments.remove(appointment1);/*remove from appointments database*/
                System.out.println("Confirmation succeed");
                return;
            }
        }
        System.out.println("No appointment with that ID in the database");
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
     * returns the citizen if login succeed /returns null otherwise
     *
     * @param password
     * @param AMKA
     */
    public Citizen Login(String AMKA, String password) {
        for (Citizen value : Citizens) {
            if (value.getAMKA().equals(AMKA)) {
                if (value.getPassword().equals(password)) {
                    /*login succed*/
                    System.out.println("login successfully");
                    return value;
                } else {
                    System.out.println("Wrong password");
                    return null;
                }
            }
        }
        System.out.println("no citizen with that AMKA");
        return null;
    }

    /**
     * Login to the system as nurse
     * to login ginete me username(Last_name) kai password(hashcode)
     * returns the nurse if login succeed /returns null otherwise
     *
     * @param password
     */
    public Nurse Login_nurse(String username, int password) {
        for (Nurse nurse : Nurses) {
            if (nurse.Get_nurseID() == password) {
                System.out.println(nurse.getLast_name());
                if (Objects.equals(nurse.getLast_name(), username)) {
                    System.out.println("Login successfully");
                    return nurse;
                }
                else
                    System.out.println("Wrong username");
            }
        }
        System.out.println("wrong password");
        return null;
    }
}

