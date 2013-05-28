package com.fabiale.vegetarianguide.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "reviews")
@SequenceGenerator(name = "SEQ_REVIEW", sequenceName = "SEQ_REVIEW", initialValue = 1, allocationSize = 1)
@XmlRootElement
@XmlType
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Review implements Serializable {

	private static final long serialVersionUID = 6608637231530466279L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REVIEW")
	private Integer id;
	@ManyToOne
    @JoinColumn(name="user_id", nullable = false)
	@ForeignKey(name = "FK_REVIEW_USER")
	private User user;
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Min(1) @Max(5)
	private int rating;
	@NotEmpty @Length(max = 40) 
	private String title;
	@Column(length = 1000)
	@NotEmpty @Length(max = 1000)
	private String description;
	@Length(max = 255) 
	private String pros;
	@Length(max = 255) 
	private String cons;
	@ManyToOne
	@JoinColumn(name = "restaurant_id", nullable = false)
	@ForeignKey(name = "FK_REVIEW_RESTAURANT")
	private Restaurant restaurant;
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPros() {
		return pros;
	}

	public void setPros(String pros) {
		this.pros = pros;
	}

	public String getCons() {
		return cons;
	}

	public void setCons(String cons) {
		this.cons = cons;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [id=");
		builder.append(id);
		builder.append(", user=");
		builder.append(user);
		builder.append(", date=");
		builder.append(date);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", pros=");
		builder.append(pros);
		builder.append(", cons=");
		builder.append(cons);
		builder.append("]");
		return builder.toString();
	}
}
