

abstract class Medical_Staff extends Person {
    private String Hospital_name;
    private String Department_name;
    private String Intership;
    private Appointment[] MS_Appointments;


    public String Get_hospital_name() {
        return this.Hospital_name;
    }

    public String Get_department_name() {
        return this.Department_name;
    }


    String getIntership() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.Intership;
    }

    void setIntership(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.Intership = value;
    }

    Appointment[] getMS_Appointments() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.MS_Appointments;
    }
    void setMS_Appointments(Appointment[] value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.MS_Appointments = value;
    }

}
