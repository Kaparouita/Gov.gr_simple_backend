package control;

import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class controler {
    Hospital pagnh;
    Hospital venizeleio;
    Vaccine Pfizer;
    Vaccine Johnson;
    ArrayList<DateClass> Available_dates = new ArrayList<>();

    System_Admin admin = new System_Admin(0);

    /**
     * init 2 hospitals for herakleion
     */
    public void init_hospitals() {
        pagnh = new Hospital("Pagnh", new Address("Hrakleio", "Panepistimiou", 71500));
        venizeleio = new Hospital("Venizeleio", new Address("Hrakleio", "Lewf.Knwsou", 44));
    }

    /**
     * init 2 vaccines
     */
    public void init_vaccines(){
        Pfizer= new Vaccine("Pfizer",0);
        Johnson= new Vaccine("Johnson" ,0);
    }

    /**
     * set an appointment
     * Available time from 8:00 to 19:40
     *
     * @param date date must have set time
     * @param citizen
     * @param hospital
     */
    public void set_appointment(DateClass date, Citizen citizen, Hospital hospital, Vaccine vaccine) {
        /*check if citizen has an appointment
         */
        if(citizen.getAppointment()!=null)
        {
            System.out.println("Citizen already has an appointment");
            System.out.println(citizen.getAppointment());
            return;
        }
        for (Nurse nurse : admin.getNurses()) {
            /*check if there is a nurse available on the hospital*/
            if (nurse.getHospital().equals(hospital)) {
                /*check if the time is available*/
                for (DateClass available_date : Available_dates) {
                    if ((available_date.getTime().equals(date.getTime())) && available_date.getDay() == date.getDay()
                            && available_date.getMonth() == date.getMonth()) {/*gia kapoio logo h sygrish object den vgenei swsta*/
                        Available_dates.remove(available_date); /*remove to date apo ta available list*/
                        Appointment appointment = new Appointment(date, citizen, hospital,
                                nurse, date.getTime(), vaccine);/*create the appointment*/
                        nurse.getMS_Appointments().add(appointment);/*authorize a nurse for the appointment*/
                        citizen.setAppointment(appointment);/*add the appointment to citizen info*/
                        admin.getAppointments().add(appointment);/*add appointment to admin database*/
                        return;
                    }
                }
                System.out.println("Time is not available");
                return;
            }
        }
        System.out.println("Didn't find an available nurse for the hospital");

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

    /*test main*/
    public static void main(String[] args) throws IOException {
        controler c = new controler();
        c.init_hospitals();

        Citizen b = new Citizen("Giannhs", "teo", new DateClass(6, 7, 2000), "234773330");
        Citizen a = new Citizen("Giorgos", "Stiv", new DateClass(6, 7, 2000), "007773330");
        Nurse nurse = new Nurse("Maria", "papadopoulou", new DateClass(6, 7, 2000), c.venizeleio);
        Nurse nur = new Nurse("Katerina", "grigoriou", new DateClass(6, 7, 2000), c.pagnh);


        Vaccine pfizer = new Vaccine("pfizer",1);
        DateClass date1 = new DateClass(30, 6, 2000);
        date1.setTime("15:00");
        DateClass date2 = new DateClass(5, 6, 2000);
        date2.setTime("18:00");

        c.admin.register(a, "helloo");

        c.admin.Add_nurse(nurse);
        c.admin.Add_nurse(nur);
        c.init_available_dates();

        c.set_appointment(date1, a, c.pagnh, pfizer);
        c.set_appointment(date2, b, c.venizeleio, pfizer);

        c.admin.getAppointments_Data();

    }
}



