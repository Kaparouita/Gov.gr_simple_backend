package model;

import java.util.Date;

public abstract class Person {
    private String First_name;
    private String Fathers_name;
    private String Last_name;
    private int Phone_number;
    private DateClass Born_date;



    String getFirst_name() {
        return this.First_name;
    }
    void setFirst_name(String value) {
        this.First_name = value;
    }
    String getFathers_name() {
        return this.Fathers_name;
    }
    void setFathers_name(String value) {
        this.Fathers_name = value;
    }
    String getLast_name() {
        return this.Last_name;
    }
    void setLast_name(String value) {
        this.Last_name = value;
    }
    int getPhone_number() {
        return this.Phone_number;
    }
    void setPhone_number(int value) {
        this.Phone_number = value;
    }
    DateClass getBorn_date() {
        return this.Born_date;
    }
    void setBorn_date(DateClass value) {
        this.Born_date = value;
    }

}
