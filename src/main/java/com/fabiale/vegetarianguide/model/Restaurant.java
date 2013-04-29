package com.fabiale.vegetarianguide.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
import org.springframework.context.i18n.LocaleContextHolder;

@Entity(name = "restaurants")
@SequenceGenerator(name="SEQ_RESTAURANT", sequenceName="SEQ_RESTAURANT")
public class Restaurant implements Serializable, Comparable<Restaurant> {

	private static final long serialVersionUID = 6594634391946827288L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESTAURANT")
	private Integer id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String street;
	@NotNull @Range(min = 1)
	private Integer number;
	private String postalCode;
	private String city;
	private String state;
	@ManyToOne
    @JoinColumn(name="country_id", nullable = false)
	private Country country;
	private Double latitude;
	private Double longitude;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Type type;
	@URL
	private String website;
	@Transient
	private Double distance;
	private String phone;
	private String description;
	@OneToOne
	@JoinColumn(name="created_by")
	private User createdBy;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id", nullable = false)
	private List<Review> reviews;

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
		return this.latitude + "," + this.longitude;
	}
	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDistanceString() {
		Locale locale = LocaleContextHolder.getLocale();
		NumberFormat fmt = NumberFormat.getInstance(locale);
		fmt.setMaximumFractionDigits(2);
		fmt.setMinimumFractionDigits(2);
		if(distance < 1000)
			return fmt.format(distance) + " m";
		else
			return fmt.format(distance/1000) + " km";
	}
	
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Restaurant [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", street=");
		builder.append(street);
		builder.append(", number=");
		builder.append(number);
		builder.append(", postalCode=");
		builder.append(postalCode);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", country=");
		builder.append(country);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", type=");
		builder.append(type);
		builder.append(", website=");
		builder.append(website);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", description=");
		builder.append(description);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Restaurant o) {
		return this.distance.compareTo(o.getDistance());
	}
}
