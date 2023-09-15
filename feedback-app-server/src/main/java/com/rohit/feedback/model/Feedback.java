package com.rohit.feedback.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date; // Import the Date class

@Entity
@Table(name = "feedbacks")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	private String comment;
	private Long rating;

	@Temporal(TemporalType.DATE) // Specify the TemporalType as DATE
	private Date date; // Add the date field

	public Feedback() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public Date getDate() { // Getter for the date field
		return date;
	}

	public void setDate(Date date) { // Setter for the date field
		this.date = date;
	}
}
