package control;


import model.Citizen;
import model.DateClass;

import java.util.Objects;
import java.util.Scanner;

/*Terminal test*/
public class main {
    public static void main(String[] args) {
        controler c = new controler();
        Citizen b = new Citizen("Giannhs", "teo", new DateClass(6, 7, 2000), "1");
        c.admin.register(b, "123456");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {


            System.out.println("/----------------------------------------/\n" +
                    "\nType login / register or quit(to exit) || Type login_MS to login as nurse");
            String todo = scanner.nextLine();
            /*if login*/
            if (Objects.equals(todo, "login")) {
                System.out.println("Type your AMKA");
                String AMKA = scanner.nextLine();
                System.out.println("Type your password");
                String password = scanner.nextLine();
                if(c.admin.Login(AMKA, password)){
                    /* after login in you will have the options to
                       1.set an appointment
                       2.cancel an appointment
                       3.print your covid-19 certificate
                       4.logout
                     */
                    System.out.println("Type : (1/2/3/4) \n" +
                            "     1. Set an appointment\n" +
                            "     2. Cancel an appointment\n" +
                            "     3. Print your covid-19 certificate\n" +
                            "     4. Logout");
                    int choice=scanner.nextInt();
                    /*set an appointment*/
                    if(choice==1){

                    }
                    /*cancel an appointment*/
                    else if(choice==2){

                    }
                    /*print your covid-19 certificate*/
                    else if(choice==3){

                    }
                    /*logout*/
                    else if(choice==4){

                    }
                    break;
                };
            }




            /*if register*/
            else if (Objects.equals(todo, "register")) {
                System.out.println("Type your first name");
                String firstname = scanner.nextLine();
                System.out.println("\nType your Last name");
                String lastname = scanner.nextLine();
                System.out.println("\nType your AMKA");
                String AMKA = scanner.nextLine();

                System.out.println("\nType your Birthday date (format example 6,7,2000) ");
                System.out.println("Day : ");
                int day= scanner.nextInt();
                System.out.println("Month : ");
                int month = scanner.nextInt();
                System.out.println("Year : ");
                int year = scanner.nextInt();

                DateClass date=new DateClass(day,month,year);

                Citizen citizen = new Citizen(firstname, lastname,date,AMKA);
                boolean info=true;
                System.out.println("\n Double check your info !");
                System.out.println("/----------------------------------------/");
                System.out.println(citizen);
                System.out.println("/----------------------------------------/");
                while(info) {
                    System.out.println("Type yes if the info is correct / type no if its not");
                    String info_check = scanner.nextLine();
                    /*an einai lathos ta stoixeia vges*/
                    if (info_check.equals("no")){
                        info=false;
                    }
                    else if(info_check.equals("yes")){
                        boolean pass=true;
                        /*create password*/
                        while(pass) {
                            System.out.println("Please type the password you want to use (It must be at least 6 char/numbers)");
                            String password1 = scanner.nextLine();
                            System.out.println("Type it again to check if they match");
                            String password2 = scanner.nextLine();
                            if(password1.equals(password2)&&password1.length()>5){
                                c.admin.register(citizen,password1);
                                System.out.println("\nRegister successfully");
                                pass=false;
                                info=false;
                            }
                            else if(!password1.equals(password2)){
                                System.out.println("Passwords dont match");
                            }
                            else {
                                System.out.println("Password need to be at least 6 char");
                            }
                        }

                    }
                    else
                        System.out.println("Wrong input");
                }

            }
            /*if quit*/
            else if (Objects.equals(todo, "quit")) {
                flag = false;
                /*if wrong input*/
            } else

                System.out.println("wrong input");
        }
        scanner.close();
    }
}