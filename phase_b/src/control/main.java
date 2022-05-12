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
        c.admin.register(b,"123456");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type login or register");
        String todo = scanner.nextLine();
        /*if login*/
        if (Objects.equals(todo, "login")) {
            System.out.println("Type your AMKA");
            String AMKA = scanner.nextLine();
            System.out.println("Type your password");
            String password = scanner.nextLine();
            c.admin.Login(AMKA,password);
        }
        /*if register*/
        else if (Objects.equals(todo, "register")) {

        }
        else
            System.out.println("wrong input");
    }
}