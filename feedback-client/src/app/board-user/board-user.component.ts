import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {
  errorMessage?: string = '';
  feedbackData = [];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUserBoard().subscribe({
      next: data => {
        this.feedbackData = data;
      },
      error: err => {
        if (err.error) {
          try {
            const res = JSON.parse(err.error);
            this.errorMessage = res.message;
          } catch {
            this.errorMessage = `Error with status: ${err.status} - ${err.statusText}`;
          }
        } else {
          this.errorMessage = `Error with status: ${err.status}`;
        }
      }
    });
  }
}
