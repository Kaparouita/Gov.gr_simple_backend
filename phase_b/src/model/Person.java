package model;

import java.io.Serializable;
import java.util.Date;

public abstract class Person implements Serializable {
    private String First_name;
    private String Fathers_name;
    private String Last_name;
    private String Phone_number;
    private DateClass Born_date;



    public String getFirst_name() {
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
    public String getLast_name() {
        return this.Last_name;
    }
    void setLast_name(String value) {
        this.Last_name = value;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    DateClass getBorn_date() {
        return this.Born_date;
    }
    void setBorn_date(DateClass value) {
        this.Born_date = value;
    }

    @Override
    public String toString() {
        return
                "First_name='" + First_name + '\'' +
                ", Fathers_name='" + Fathers_name + '\'' +
                ", Last_name='" + Last_name + '\'' +
                ", Phone_number='" + Phone_number + '\'' +
                ", Born_date=" + Born_date +" , "
                ;
    }
}
