package com.shop.models;

import com.shop.validator.Name;
import com.shop.validator.Phone;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * Created by apbudzinski on 2015-02-05.
 */
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column(name = "first_name", nullable = false)
    @NotEmpty(message = "First name is required")
    @Name
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotEmpty(message = "Last name is required")
    @Name
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    @NotEmpty(message = "Phone number is required")
    @Phone
    private String phoneNumber;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "address_id", referencedColumnName = "id")
    private Address address;


    public Person() {
        this(new Address());
    }

    public Person(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address=" + address +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
