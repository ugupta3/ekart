package com.ekart.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the et_address database table.
 */
@Entity
@Table(name = "et_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id", unique = true, nullable = false)
    private BigInteger addressId;

    @Column(name = "address_line1", nullable = false, length = 255)
    private String addressLine1;

    @Column(name = "address_line2", length = 255)
    private String addressLine2;

    @Column(nullable = false, length = 255)
    private String city;

    @Column(length = 255)
    private String country;

    @Column(name = "email_address", length = 255)
    private String emailAddress;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_default")
    private Boolean isDefault;

    @Column(name = "is_mailing")
    private Boolean isMailing;

    @Column(length = 255)
    private String name;
    @Column
    private String phone;

    @Column(name = "postal_code", length = 255)
    private String postalCode;

    @Column
    private String state;

    //bi-directional many-to-one association to UserAccount
    @OneToMany(mappedBy = "address")
    private List<UserAccount> userAccounts;


    public Address() {
    }

    public BigInteger getAddressId() {
        return addressId;
    }

    public void setAddressId(BigInteger addressId) {
        this.addressId = addressId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getIsMailing() {
        return isMailing;
    }

    public void setIsMailing(Boolean isMailing) {
        this.isMailing = isMailing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(List<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}