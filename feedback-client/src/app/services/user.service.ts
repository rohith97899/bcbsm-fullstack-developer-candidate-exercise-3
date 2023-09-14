import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + '/getFeedbacks');
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + '/getFeedbacks');
  }

  createFeedback(feedback: any): Observable<any> {
    return this.http.post(API_URL + '/addFeedback', feedback);
  }
}
