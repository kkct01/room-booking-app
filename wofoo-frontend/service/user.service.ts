import { User } from './../class/user';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  private baseUrl = "http://localhost:8080/wofoo/user";

  public getUser(name : string) : Observable<any> {
    const url = `${this.baseUrl}/user?name=${name}`
    return this.http.get<any>(url);
  }

}

