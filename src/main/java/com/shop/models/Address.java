package com.shop.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by apbudzinski on 2015-02-05.
 */
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    @Column
    int id;

    @Column(nullable = false)
    @NotEmpty(message = "Country is required")
    private String country;

    @Column(nullable = false)
    @NotEmpty(message = "City is required")
    private String city;

    @Column(nullable = false)
    @NotEmpty(message = "Street is required")
    private String street;

    @Column(name = "house_number", nullable = false)
    @NotEmpty(message = "House number is required")
    private String houseNumber;

    @Column(name = "postal_code", nullable = false)
    @NotEmpty(message = "Postal code is required")
    private String postalCode;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
