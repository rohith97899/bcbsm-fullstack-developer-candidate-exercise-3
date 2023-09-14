package com.rohit.feedback.repository;

import com.rohit.feedback.model.Feedback;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
   // @Query(value = "SELECT * FROM feedbacks WHERE feedbacks.user_id = :userId", nativeQuery = true)
   // public List<Feedback> getFeedbacksByUser(Long userId);

    List<Feedback> findByUserId(Long userId);

//
}
