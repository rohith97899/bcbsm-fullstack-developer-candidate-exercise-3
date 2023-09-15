package com.rohit.feedback.repository;

import com.rohit.feedback.model.Feedback;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByUserId(Long userId);
}
