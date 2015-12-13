package com.ekart.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the et_user_account database table.
 * 
 */
@Entity
@Table(name="ek_user_account")
public class UserAccount  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=1)
	private String algorithm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Column(nullable=false, length=100)
	private String email;

	@Column(name="password_encrypted_value", length=40)
	private String passwordEncryptedValue;

	@Column(name="password_salt", length=100)
	private String passwordSalt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="password_updated_at")
	private Date passwordUpdatedAt;

	@Column
	private String phone;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@ManyToOne
	@JoinColumn(name="address_id",insertable =false ,updatable = false)
	private Address address;


	@OneToMany(mappedBy = "userAccount")
	private List<Pricing> pricing;


	public UserAccount() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlgorithm() {
		return this.algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
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

	public String getPasswordEncryptedValue() {
		return this.passwordEncryptedValue;
	}

	public void setPasswordEncryptedValue(String passwordEncryptedValue) {
		this.passwordEncryptedValue = passwordEncryptedValue;
	}

	public String getPasswordSalt() {
		return this.passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public Date getPasswordUpdatedAt() {
		return this.passwordUpdatedAt;
	}

	public void setPasswordUpdatedAt(Date passwordUpdatedAt) {
		this.passwordUpdatedAt = passwordUpdatedAt;
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

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Pricing> getPricing() {
		return pricing;
	}

	public void setPricing(List<Pricing> pricing) {
		this.pricing = pricing;
	}
}