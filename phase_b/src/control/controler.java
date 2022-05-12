package control;

import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class controler {
    Hospital pagnh;
    Hospital venizeleio;
    ArrayList<DateClass> Available_dates = new ArrayList<>();

    System_Admin admin = new System_Admin(0);

    /**
     * init 2 hospitals for herakleion
     */
    public void init_hospitals() {
        pagnh = new Hospital("Pagnh", new Address("Hrakleio", "Panepistimiou", 71500));
        venizeleio = new Hospital("Venizeleio", new Address("Hrakleio", "Lewf.Knwsou", 44));
    }

    public void set_appointment(DateClass date, Citizen citizen, String hospital) {

    }

    /**
     * initialize available dates to book appointments
     */
    public void init_available_dates() {
        ArrayList<String> days = new ArrayList<>();
        ArrayList<String> time = new ArrayList<>();
        for (int i = 8; i < 20; i++) {
            for (int j = 0; j < 60; ) {
                if(j==0)
                    time.add(i+":0"+j);
                else
                    time.add(i+":"+j);
                j=j+20;
            }
        }
        for(int i=1;i<32;i++) {
            for(int j=0;j< time.size();j++) {
                DateClass init_date = new DateClass(i, 6, 2000);
                init_date.setTime(time.get(j));
                Available_dates.add(init_date);
            }
        }
        for (DateClass available_date : Available_dates) System.out.println(available_date+" "+available_date.getTime());
    }

    /*test main*/
    public static void main(String[] args) throws IOException {
        System_Admin admin1 = new System_Admin(0);
        controler c = new controler();
        c.init_hospitals();

        Citizen a = new Citizen("Giorgos", "Stiv", new DateClass(6, 7, 2000), "007773330");
        Nurse nurse = new Nurse("Maria", "papadopoulou", new DateClass(6, 7, 2000), c.venizeleio);
        Nurse nur = new Nurse("Katerina", "grigoriou", new DateClass(6, 7, 2000), c.pagnh);


        admin1.register(a, "helloo");

        admin1.Add_nurse(nurse);
        admin1.Add_nurse(nur);
        admin1.getNurses_Data();

        c.init_available_dates();

    }
}



