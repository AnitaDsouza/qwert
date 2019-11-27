import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  private baseUrl ='http://localhost:9080/api/feedbacks';

  constructor(private http: HttpClient) { }

  getFeedback(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createfeedback(feedback: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, feedback);
  }

  updatefeedback(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deletefeedback(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getfeedbackList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

}
