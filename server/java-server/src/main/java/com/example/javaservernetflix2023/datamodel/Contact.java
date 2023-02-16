package com.example.javaservernetflix2023.datamodel;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "CONTACTS")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTHDATE")
    private Date birthDate;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address BillingAddress;


    public Contact() {
    }


    public Contact(int id,String name, Date birthDate, String gender, String email, Address BillingAddress) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.BillingAddress = BillingAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getBillingAddress() {
        return BillingAddress;
    }

    public void setBillingAddress(Address BillingAddress) {
        this.BillingAddress = BillingAddress;
    }



    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", BillingAddress='" + BillingAddress + '\'' +
                '}';
    }
}
