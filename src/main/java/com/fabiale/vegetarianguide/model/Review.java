package com.fabiale.vegetarianguide.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "reviews")
@SequenceGenerator(name = "SEQ_REVIEW", sequenceName = "SEQ_REVIEW")
public class Review implements Serializable {

	private static final long serialVersionUID = 6608637231530466279L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REVIEW")
	private Integer id;
	@ManyToOne
    @JoinColumn(name="user_id", nullable = false)
	private User user;
	private Date date;
	private int rating;
	private String title;
	private String description;
	private String pros;
	private String cons;

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
