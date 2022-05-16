package model;

import java.io.Serializable;

public class Hospital implements Serializable {
    String name;
    Address hospital_address;
    String department_name;

    /**
     * Create a hospital
     * @param name hospital name
     * @param address hospital address
     */
    public Hospital (String name,Address address){
        this.name=name;
        this.hospital_address=address;
    }
    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHospital_address(Address hospital_address) {
        this.hospital_address = hospital_address;
    }

    public String getName() {
        return name;
    }

    public Address getHospital_address() {
        return hospital_address;
    }

    public String getDepartment_name() {
        return department_name;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", hospital_address=" + hospital_address +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}
