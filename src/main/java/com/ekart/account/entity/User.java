package com.ekart.account.entity;

import com.ekart.entity.Address;
import com.ekart.entity.Pricing;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the et_user_account database table.
 */
@Entity
@Table(name = "ek_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long id;

    private String firstName;

    private String lastName;

    @Column(length = 60)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;

    private String phone;

    @Column(nullable = false)
    private long address_id;

    @Column(nullable = false)
    private long role_id;

    private boolean enabled;

    private boolean tokenExpired;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name="id",referencedColumnName ="role_id")
    private List<Role> roles;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "id",referencedColumnName = "address_id")
    private List<Address> address;


    @OneToMany(mappedBy = "user")
    private List<Pricing> pricing;//TODO check if we can remove this


    public User() {
    }

    public User(String lastName, String firstName, String password, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Pricing> getPricing() {
        return pricing;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public void setPricing(List<Pricing> pricing) {
        this.pricing = pricing;
    }
}