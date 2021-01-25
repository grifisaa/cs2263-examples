package edu.isu.cs.cs2263.gson;

import java.io.Serializable;

public class PhoneNumber implements Serializable {

    /*
    {
      "areaCode": "value",
      "number": "value",
    }
    */
    private String areaCode;
    private String number;

    public PhoneNumber() {}

    public PhoneNumber(String areaCode, String number) {

        this.areaCode = areaCode;
        this.number = number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;

        PhoneNumber that = (PhoneNumber) o;

        if (!getAreaCode().equals(that.getAreaCode())) return false;
        return getNumber().equals(that.getNumber());
    }

    @Override
    public int hashCode() {
        int result = getAreaCode().hashCode();
        result = 31 * result + getNumber().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%s) %s", areaCode, number);
    }
}
