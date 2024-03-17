package com.matri.address.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "address")
public class Address extends Object implements Serializable {

	private static final long serialVersionUID = -7693438653090945983L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private int flatNumber;
	private String landMark;
	private String city;
	private String district;
	private String state;
	private int pinNumber;
	private String country;
	private int isEnable;

	public Address() {
		super();

	}

	public Address(int addressId, int flatNumber, String landMark, String city, String district, String state,
			int pinNumber, String country, int isEnable) {
		super();
		this.addressId = addressId;
		this.flatNumber = flatNumber;
		this.landMark = landMark;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pinNumber = pinNumber;
		this.country = country;
		this.isEnable = isEnable;

	}

	// @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinColumn(name = "customer_id", referencedColumnName = "addressId")

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", flatNumber=" + flatNumber + ", landMark=" + landMark + ", city="
				+ city + ", district=" + district + ", state=" + state + ", pinNumber=" + pinNumber + ", country="
				+ country + ", isEnable=" + isEnable + "]";
	}

}
