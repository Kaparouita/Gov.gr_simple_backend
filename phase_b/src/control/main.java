package control;


import model.*;

import java.io.IOException;
import java.util.Scanner;

/*Terminal test*/
public class main {
    public static void main(String[] args) throws IOException {
        controler c = new controler();

       /*TEST
        Citizen b = new Citizen("Giannhs", "teo", new DateClass(6, 7, 2000), "1");
        c.admin.register(b, "123456");
        */
        boolean flag = true;

        Scanner scanner = new Scanner(System.in);
        while (flag) {
            int todo;
            System.out.println("""
                    /----------------------------------------/

                    Type (1,2,3,4)
                    1 : Login
                    2 : Register
                    3 : Login as Nurse
                    4 : Exit""");
            String todo_string = scanner.nextLine();
            todo = Integer.parseInt(todo_string);
            /*if login*/
            if (todo == 1) {
                System.out.println("Type your AMKA");
                String AMKA = scanner.nextLine();
                System.out.println("Type your password");
                String password = scanner.nextLine();
                Citizen citizen = c.admin.Login(AMKA, password);
                if (citizen != null) {
                    /* after login in you will have the options to
                       1.set an appointment
                       2.cancel an appointment
                       3.print your covid-19 certificate
                       4.logout
                   */
                    boolean choose = true;
                    while (choose) {
                        System.out.println("""
                                Type : (1/2/3/4)\s
                                     1. Set an appointment
                                     2. Cancel an appointment
                                     3. Print your covid-19 certificate
                                     4. Logout""");
                        int choice = scanner.nextInt();
                        scanner.nextLine();/*consume next INT*/
                        /*set an appointment*/
                        if (choice == 1) {
                            c.admin.getAvailable_Dates_Data();
                            System.out.println("/----------------------------------------/\n");
                            System.out.println("These are the available dates you can book an appointment");
                            choose_appointment(c, citizen);
                        }
                        /*cancel an appointment*/
                        else if (choice == 2) {
                            cancel_appointment(c, citizen);
                        }
                        /*print your covid-19 certificate*/
                        else if (choice == 3) {
                            if(citizen.IsVaccinated()) {
                                System.out.println(citizen.getCovid_19_certificate().print_certificate());
                                System.out.println("Do you want to create a txt with the certificate? Type y/n");
                                String certificate=scanner.nextLine();
                                if(certificate.equals("y")){
                                    citizen.getCovid_19_certificate().print_certificate_to_txt();
                                }
                                else if(certificate.equals("n")){

                                }
                                else
                                    System.out.println("wrong input");
                            }
                            else
                                System.out.println("You are not vaccinated yet");
                        }
                        /*logout*/
                        else if (choice == 4) {
                            choose = false;
                        }
                    }
                }
            }

            /*if register*/
            else if (todo == 2) {
                register(c);
            }
            /*if nurse_login*/
            else if (todo == 3) {
                System.out.println("Type your username");
                String username = scanner.nextLine();
                System.out.println("Type your password");
                int password = scanner.nextInt();
                scanner.nextLine();/*consume nextInt*/
                Nurse nurse = c.admin.Login_nurse(username, password);
                boolean flag1 = true;

                if (nurse != null)/*login succed*/ {
                    while (flag1) {
                        System.out.println("""
                                Type (1,2)
                                1 : Confirm a vaccination
                                2 : Exit""");
                        int choice = scanner.nextInt();
                        scanner.nextLine();/*consume next Int*/
                        /*CONFIRM VACCINATION*/
                        if (choice == 1) {
                            System.out.println("Your appointments");
                            System.out.println(nurse.getMS_Appointments());
                            System.out.println("Type appointment ID to remove");
                            int appointment = scanner.nextInt();
                            c.admin.confirm_vaccination(appointment);
                        }
                        /*EXIT*/
                        else if (choice == 2) {
                            flag1 = false;
                        }
                    }
                }

            }
            /*if exit*/
            else if (todo == 4) {
                flag = false;
                /*if wrong input*/
            } else
                System.out.println("wrong input");
        }
        scanner.close();
    }

    /**
     * Ask information in order to book an appointment
     *
     * @param c       controller
     * @param citizen citizen
     */
    public static void choose_appointment(controler c, Citizen citizen) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        /*CHOOSE DATE*/
        System.out.println("Choose the DAY :");
        int day = scanner.nextInt();
        System.out.println("Choose the Month :");
        int month = scanner.nextInt();
        scanner.nextLine();/*consume next line*/

        System.out.println("Choose the Time : (time format example 18:00)");
        String time = scanner.nextLine();
        DateClass date = new DateClass(day, month, 2000);
        date.setTime(time);

        /*CHOOSE HOSPITAL*/
        Hospital hospital1 = null;

        while (flag) {
            System.out.println("Choose the medical center : type (1,2)\n1 : Venizeleio\n2 : Pagnh");
            int hospital = scanner.nextInt();
            scanner.nextLine();/*consume next line*/
            if (hospital == 1) {
                hospital1 = c.venizeleio;
                flag = false;
            } else if (hospital == 2) {
                hospital1 = c.pagnh;
                flag = false;
            } else {
                System.out.println("Wrong input");
            }
        }
        flag = true;
        /*CHOOSE VACCINE*/
        Vaccine vaccine = null;

        while (flag) {
            System.out.println("Choose the vaccine : type (1,2)\n1 : Johnson\n2 : Pfizer");
            int vaccine1 = scanner.nextInt();
            scanner.nextLine();/*consume next line*/
            if (vaccine1 == 1) {
                vaccine = c.Johnson;
                vaccine.setDose(citizen.getCurr_dose());
                flag = false;
            } else if (vaccine1 == 2) {
                vaccine = c.Pfizer;
                vaccine.setDose(citizen.getCurr_dose());
                flag = false;
            } else {
                System.out.println("Wrong input");
            }
        }
        System.out.println("Type your phone to get notified via SMS");
        String phone = scanner.nextLine();
        citizen.setPhone_number(phone);

        if (c.set_appointment(date, citizen, hospital1, vaccine)) {
            System.out.println(citizen.getAppointment().toString());
        }
    }

    /**
     * Ask information in order to register
     *
     * @param c controller
     */
    public static void register(controler c) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your first name");
        String firstname = scanner.nextLine();
        System.out.println("\nType your Last name");
        String lastname = scanner.nextLine();
        System.out.println("\nType your AMKA");
        String AMKA = scanner.nextLine();

        System.out.println("\nType your Birthday date (format example 6,7,2000) ");
        System.out.println("Day : ");
        int day = scanner.nextInt();
        System.out.println("Month : ");
        int month = scanner.nextInt();
        System.out.println("Year : ");
        int year = scanner.nextInt();
        scanner.nextLine();/*consume next line*/

        DateClass date = new DateClass(day, month, year);

        Citizen citizen = new Citizen(firstname, lastname, date, AMKA);
        boolean info = true;
        System.out.println("\n Double check your info !");
        System.out.println("/----------------------------------------/");
        System.out.println(citizen);
        System.out.println("/----------------------------------------/");
        while (info) {
            System.out.println("Type yes if the info is correct / type no if its not");
            String info_check = scanner.nextLine();
            /*an einai lathos ta stoixeia vges*/
            if (info_check.equals("no")) {
                info = false;
            } else if (info_check.equals("yes")) {
                boolean pass = true;
                /*create password*/
                while (pass) {
                    System.out.println("Please type the password you want to use (It must be at least 6 char/numbers)");
                    String password1 = scanner.nextLine();
                    System.out.println("Type it again to check if they match");
                    String password2 = scanner.nextLine();
                    if (password1.equals(password2) && password1.length() > 5) {
                        c.admin.register(citizen, password1);
                        System.out.println("\nRegister successfully");
                        pass = false;
                        info = false;
                        return;
                    } else if (!password1.equals(password2)) {
                        System.out.println("Passwords dont match");
                    } else {
                        System.out.println("Password need to be at least 6 char");
                    }
                }

            } else
                System.out.println("Wrong input");
        }
    }

    /**
     * @param c
     */
    public static void cancel_appointment(controler c, Citizen citizen) {
        Scanner scanner = new Scanner(System.in);
        if (citizen.getAppointment() != null) {
            while (true) {
                System.out.println("Your appointment : ");
                System.out.println(citizen.getAppointment());
                System.out.println("Are you sure you want to cancel ?\n Type (1,2)\n" +
                        "1 : Cancel" +
                        "\n2 : Exit");
                int option = scanner.nextInt();
                if (option == 1) {
                    c.Cancel_appointment(citizen.getAppointment());
                    return;
                } else if (option == 2) {
                    return;
                } else
                    System.out.println("Wrong input");
            }
        } else
            System.out.println("You don't have an appointment!");
    }
}
