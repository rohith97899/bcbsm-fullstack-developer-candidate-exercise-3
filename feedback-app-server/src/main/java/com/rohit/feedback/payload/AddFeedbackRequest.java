package com.rohit.feedback.payload;

import javax.validation.constraints.NotBlank;

public class AddFeedbackRequest {

    private Long userId;

    private String comment;

    private Long rating;

    public Long userId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String comment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long rating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
