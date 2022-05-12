package model;

abstract class Medical_Staff extends Person {
    private Hospital hospital;
    private String Intership;
    private Appointment[] MS_Appointments;


    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    String getIntership() {
        return this.Intership;
    }

    void setIntership(String value) {
        this.Intership = value;
    }

    Appointment[] getMS_Appointments() {
        return this.MS_Appointments;
    }
    void setMS_Appointments(Appointment[] value) {
        this.MS_Appointments = value;
    }



}
