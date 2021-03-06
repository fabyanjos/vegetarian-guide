package com.fabiale.vegetarianguide.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
import org.springframework.context.i18n.LocaleContextHolder;

@Entity(name = "restaurants")
@SequenceGenerator(name = "SEQ_RESTAURANT", sequenceName = "SEQ_RESTAURANT", initialValue = 1, allocationSize = 1)
@XmlRootElement
@XmlType
public class Restaurant implements Serializable, Comparable<Restaurant> {

	private static final long serialVersionUID = 1245311504149783008L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESTAURANT")
	private Integer id;
	@NotEmpty @Length(max = 255)
	@Column(unique = true)
	private String name;
	@NotEmpty @Length(max = 255)
	private String street;
	@NotNull @Range(min = 1)
	private Integer number;
	@Length(max = 255)
	private String postalCode;
	@NotEmpty
	@Length(max = 255)
	private String city;
	@NotEmpty
	@Length(max = 255)
	private String state;
	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	@ForeignKey(name = "FK_RESTAURANT_COUNTRY")
	@NotNull
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
	@Transient
	private Integer rating;
	private String phone;
	@Column(length = 1000)
	@NotEmpty
	@Length(max = 1000)
	private String description;
	@OneToOne
	@JoinColumn(name = "created_by")
	@ForeignKey(name = "FK_RESTAURANT_USER")
	private User createdBy;
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Column(insertable = false, updatable = false)
	@Transient
	private String imageUrl;
	@org.hibernate.annotations.Type(type="yes_no")
	private boolean delivery = false;
	private String openingTimes;
	private int price;
	
	public String getOpeningTimes() {
		return openingTimes;
	}

	public void setOpeningTimes(String openingTimes) {
		this.openingTimes = openingTimes;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isDelivery() {
		return delivery;
	}

	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

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
		if(distance != null) {
			Locale locale = LocaleContextHolder.getLocale();
			NumberFormat fmt = NumberFormat.getInstance(locale);
			fmt.setMaximumFractionDigits(2);
			fmt.setMinimumFractionDigits(2);
			if (distance < 1000)
				return fmt.format(distance) + " m";
			else
				return fmt.format(distance / 1000) + " km";
		} else
			return "";
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getNameUrl() {
		return this.name.replaceAll(" ", "-").toLowerCase();
	}

	public String getAddress() {
		StringBuffer sb = new StringBuffer();
		sb.append(street != null ? street : "").append(",")
				.append(number != null ? number : "").append(",")
				.append(city != null ? city : "").append(",")
				.append(state != null ? state : "").append(",")
				.append(country != null ? country.getName() : "").append(",");

		return sb.toString();
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
		if(this.distance == null && o.getDistance() != null)
			return -1;
		else if(this.distance != null &&  o.getDistance() == null)
			return 1;
		else if(this.distance == null && o.getDistance() == null)
			return 0;
		return this.distance.compareTo(o.getDistance());
	}
}
