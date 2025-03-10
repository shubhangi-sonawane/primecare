import { HttpClient, HttpClientXsrfModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  constructor(private httpClient:HttpClient) { }

  private baseUrl:string ="http://localhost:8080/api/v2";

  getAllAppointments():Observable<Appointment[]>{

    return this.httpClient.get<Appointment[]>(this.baseUrl);
  }

  createAppointment(appointment:Appointment):Observable<Appointment>{

  return this.httpClient.post<Appointment>(`${this.baseUrl}/insert`,appointment);

  }
  deleteAppointment(id:number):Observable<object>{
    return this.httpClient.delete(`${this.baseUrl}/appointments/${id}`);
  }
}

