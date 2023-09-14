import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {
  feedbackData = [];
  errorMessage = '';
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getAdminBoard().subscribe({
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
