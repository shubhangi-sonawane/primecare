import { Component } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Appointment } from '../appointment';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent {
  searchText:string="";
  appointments:Appointment[]=[];
  constructor(private AppointmentService:AppointmentService){}

  ngOnInit():void{
    this.getAppointments();

  }
  getAppointments(){
    this.AppointmentService.getAllAppointments().subscribe(data=>{
      console.log(data)
      this.appointments=data;

    });
  }

searchAppointments() {
  if (this.searchText.trim() === '') {
    // If the search text is empty, reset to the original patient list
    this.getAppointments();
  } else {
    // Filter patients based on the search text
    this.appointments = this.appointments.filter(appointment =>
      Appointment.name.toLowerCase().includes(this.searchText.toLowerCase())
    );
  }
}
deleteAppointment(id:number):void{
  this.AppointmentService.deleteAppointment(id).subscribe(data=>{
    console.log(data);
    this.getAppointments();
  })

}
}


