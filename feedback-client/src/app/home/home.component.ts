import { Component, OnInit } from '@angular/core';
import { StorageService } from '../services/storage.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  userRole?: string;

  constructor(private storageService: StorageService) { }

  ngOnInit(): void {
    this.userRole = this.storageService.getUser().role;
  }
}
