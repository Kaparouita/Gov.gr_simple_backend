package model;

import java.io.Serializable;

public class Address implements Serializable {
    private String City;
    private String Street;
    private int number;

    /**
     * Create an address
     * @param City polh
     * @param Street odos
     * @param number arithmos_odou
     */
    public Address(String City,String Street,int number){
        this.number=number;
        this.City=City;
        this.Street=Street;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "  " + City  +
                ",  " + Street  +
                ",  " + number +
                '}';
    }
}
