package com.rohit.feedback.controller;

import com.rohit.feedback.model.Feedback;
import com.rohit.feedback.model.Role;
import com.rohit.feedback.model.RoleName;
import com.rohit.feedback.model.User;
import com.rohit.feedback.payload.AddFeedbackRequest;
import com.rohit.feedback.payload.ApiResponse;
import com.rohit.feedback.repository.FeedbackRepository;
import com.rohit.feedback.repository.RoleRepository;
import com.rohit.feedback.repository.UserRepository;
import com.rohit.feedback.security.CurrentUser;
import com.rohit.feedback.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FeedbackController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private FeedbackRepository feedbackRepo;

    @GetMapping("/getFeedbacks")
    public List<Feedback> getFeedbacks(@CurrentUser UserPrincipal currentUser) {
        User user = userRepository.getById(currentUser.getId());
        Role role = user.getRoles().stream().findFirst().get();
        if(role.getName().equals(RoleName.ROLE_USER))
            return feedbackRepo.findByUserId(currentUser.getId());
        return feedbackRepo.findAll();
    }


    @PostMapping("/addFeedback")
    public ResponseEntity<?> addFeedback(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody AddFeedbackRequest feedbackRequest) {
        // Check if the rating is within the valid range (1 to 5)
        Long rating = feedbackRequest.rating();
        if (rating < 1 || rating > 5) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Invalid rating value. Rating must be between 1 and 5."));
        }

        Feedback feedback = new Feedback();
        feedback.setUserId(currentUser.getId());
        feedback.setComment(feedbackRequest.comment());
        feedback.setRating(rating);

        // Set the current date as the record insertion date
        feedback.setDate(new Date());
        feedbackRepo.save(feedback);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("Feedback")
                .buildAndExpand(feedback.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Feedback Created Successfully"));
    }

} //modified one
