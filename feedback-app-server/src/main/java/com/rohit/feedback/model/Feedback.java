package com.rohit.feedback.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "feedbacks")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id") // Map to the 'user_id' column in the database
	private Long userId; // Use Java naming conventions (camelCase) for field names

	private String comment;
	private Long rating;

	public Feedback() {
	}

	public Long getId() { // Use getId() instead of id()
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() { // Use getUserId() instead of user_id()
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getComment() { // Use getComment() instead of comment()
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getRating() { // Use getRating() instead of rating()
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}
}
