package control;

import model.Citizen;
import model.DateClass;
import model.Nurse;
import model.System_Admin;

import java.io.*;

public class WriteReader {

    System_Admin admin;


    public WriteReader(System_Admin admin) {
        this.admin = admin;
    }


    /**
     * Save citizens info before closing the program
     */
    public void create_save_file() throws IOException {
        try {
            String filename = "Save.bin";
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            /*CITIZENS*/
            for (Citizen citizen : admin.getCitizens()) {
                oos.writeObject(citizen);
            }
            /*NURSES*/
            for (Nurse nurse : admin.getNurses()) {
                oos.writeObject(nurse);
            }
            /*AVAILABLE DATES*/
            for (DateClass dateClass : admin.getAvailable_dates()) {
                oos.writeObject(dateClass);
            }
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

    /**
     * get Citizens saved on the bin file
     *
     * @throws IOException
     */
    public void get_data_from_save_file() throws IOException {
        File file = new File("Save.bin");
        if (!file.exists())
            return;
        String filename = "Save.bin";
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object o;
        while (true) {
            try {
                o = ois.readObject();
                if (o instanceof Citizen) {
                    /*INIT CITIZENS FROM DATABASE*/
                    admin.getCitizens().add((Citizen) o);
                } else if (o instanceof Nurse) {
                    /*INIT NURSES FROM DATABASE*/
                    admin.getNurses().add((Nurse) o);
                } else if (o instanceof DateClass) {
                    admin.getAvailable_dates().add((DateClass) o);
                } else {
                    System.out.println("error");
                }
            } catch (EOFException | ClassNotFoundException ex) {
                break;
            }
        }
        ois.close();
        /*INIT APPOINTMENTS AS WELL*/
        for (
                Citizen citizen : admin.getCitizens()) {
            if (citizen.getAppointment() != null) {
                admin.getAppointments().add(citizen.getAppointment());
                /*INIT APPOINTMENTS FOR NURSES*/
                for (Nurse nurse : admin.getNurses()) {
                    if (nurse.Get_nurseID() == citizen.getAppointment().getNurse().Get_nurseID()) {
                        nurse.getMS_Appointments().add(citizen.getAppointment());
                    }
                }
            }
        }

    }
}





