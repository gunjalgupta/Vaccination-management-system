package com.example.vaccination.schema;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.persistence.*;
import java.util.List;
@Entity
public class Users {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String mrn;
    private String email;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dob;
    private String city;
    private String state;
    private String zipcode;
    private String gender;
    private int role;  //0 = Patient  1 = Admin

    public Users(String mrn, String email, String password, String firstName, String middleName, String lastName, Date dob, String city, String state, String zipcode, String gender, int role) {
        this.mrn = mrn;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.gender = gender;
        this.role = role;
    }

    public String getMrn() {
        return mrn;
    }

    public void setMrn(String mrn) {
        this.mrn = mrn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}






