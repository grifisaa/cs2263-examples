package edu.isu.cs.cs2263.gson;

import java.io.Serializable;

public class Professor implements Serializable {

    private String firstName;
    private String lastName;
    private PhoneNumber number;
    private String email;
    private String officeLocation;

    public Professor() {}

    public Professor(String firstName, String lastName, PhoneNumber number, String email, String officeLocation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.email = email;
        this.officeLocation = officeLocation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PhoneNumber getNumber() {
        return number;
    }

    public void setNumber(PhoneNumber number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;

        Professor professor = (Professor) o;

        if (!getFirstName().equals(professor.getFirstName())) return false;
        if (!getLastName().equals(professor.getLastName())) return false;
        if (!getNumber().equals(professor.getNumber())) return false;
        if (!getEmail().equals(professor.getEmail())) return false;
        return getOfficeLocation().equals(professor.getOfficeLocation());
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getNumber().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getOfficeLocation().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %s", firstName, lastName, number.toString());
    }
}
