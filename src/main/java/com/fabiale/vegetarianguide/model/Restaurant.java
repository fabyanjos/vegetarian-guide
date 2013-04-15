package com.fabiale.vegetarianguide.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "restaurants")
@XmlRootElement
public class Restaurant implements Serializable {

	private static final long serialVersionUID = 6594634391946827288L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String street;
	private Integer number;
	private String postalCode;
	private String city;
	private String state;
	@ManyToOne
    @JoinColumn(name="country_id", nullable=false)
	private Country country;
	private Double latitude;
	private Double longitude;
	@Enumerated(EnumType.STRING)
	private Type type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public String getLatLng() {
		return this.latitude + ", " + this.longitude;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", street=" + street
				+ ", number=" + number + ", postalCode=" + postalCode
				+ ", city=" + city + ", state=" + state + ", country="
				+ country + ", latitude=" + latitude + ", longitude="
				+ longitude + ", type=" + type + "]";
	}
}
