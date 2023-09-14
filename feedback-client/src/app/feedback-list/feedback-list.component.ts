import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-feedback-list',
  templateUrl: './feedback-list.component.html',
  styleUrls: ['./feedback-list.component.css'],
})
export class FeedbackListComponent {
  @Input() feedbackList: { id: string; userId: string; comment: string; rating: number }[] = [];

  generateStars(rating: number): number[] {
    return Array.from({ length: rating }, (_, index) => index + 1);
  }
}
