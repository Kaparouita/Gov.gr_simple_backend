package control;

import model.Citizen;

import java.io.IOException;
import java.util.ArrayList;

import model.DateClass;

public class controler {


    ArrayList<Citizen> Citizen_Data = new ArrayList<>();

    /**
     * add new user to the database
     */
    public void register(Citizen citizen) {
        boolean flag = false;
        for (int i = 0; i < Citizen_Data.size(); i++) {
            if (Citizen_Data.get(i).equals(citizen)) {
                flag = true;
            }
        }
        if (flag == false)
            Citizen_Data.add(citizen);
        else
            System.out.println("Already registered");
    }

    /**
     * get citizens data for testing
     */
    public void getCitizen_Data() {
        for (int i = 0; i < Citizen_Data.size(); i++) {
            System.out.println(Citizen_Data.get(i)+" ,");
        }
    }

    /*test main*/
    public static void main(String[] args) throws IOException {
        Citizen a = new Citizen("Giorgos", "Stiv", new DateClass(6, 7, 2000), "007773330");
        Citizen b = new Citizen("Giorgis", "Stiv", new DateClass(6, 7, 2000), "007773330");
controler c=new controler();
        System.out.println(a.toString());
        c.register(a);
        c.register(b);
        c.getCitizen_Data();
    }
}
