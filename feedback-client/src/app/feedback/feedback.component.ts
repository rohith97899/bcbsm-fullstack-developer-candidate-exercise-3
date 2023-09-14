import { Component } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css'],
})
export class FeedbackComponent {
  feedback: { comment: string; rating: number } = { comment: '', rating: 1 };
  stars: number[] = [1, 2, 3, 4, 5];

  constructor(private userService: UserService) {}

  setRating(rating: number) {
    this.feedback.rating = rating;
  }

  submitFeedback() {
    this.userService.createFeedback(this.feedback).subscribe(
      (response) => {
        console.log('Feedback submitted successfully:', response);
        this.feedback = { comment: '', rating: 1 };
        window.location.reload();
      },
      (error) => {
        console.error('Error submitting feedback:', error);
      }
    );
  }
}
