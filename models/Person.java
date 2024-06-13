package Thi_thuc_hanh_Module_2.models;

public abstract class Person {

    private String name;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;

    public Person(String name, String dateOfBirth, String gender, String phoneNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return getName() + "," + getDateOfBirth() + "," + getGender() + "," + getPhoneNumber();
    }
}
