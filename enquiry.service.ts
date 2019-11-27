import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EnquiryService {

  private baseUrl ='http://localhost:9080/api/enquirys';

  constructor(private http: HttpClient) { }

  getEnquiry(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createEnquiry(enquiry: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, enquiry);
  }

  updateEnquiry(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteEnquiry(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getEnquiryList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

}
