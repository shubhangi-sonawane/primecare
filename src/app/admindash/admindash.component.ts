import { Component,OnInit } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { AdminauthService } from '../adminauth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admindash',
  templateUrl: './admindash.component.html',
  styleUrls: ['./admindash.component.css']
})
export class AdmindashComponent {
  searchText:string="";
  patients:Patient[] = [];
  constructor(private PatientService:PatientService,private AdminauthService:AdminauthService,private router:Router){}
ngOnInit():void{
  this.GetPatients();
}
  GetPatients():void{
    this.PatientService.getPatientList().subscribe((data:Patient[])=>{

      console.log(data)

this.patients=data;
});
     
    
}

searchPatients() {
  if (this.searchText.trim() === '') {
    // If the search text is empty, reset to the original patient list
    this.GetPatients();
  } else {
    // Filter patients based on the search text
    this.patients = this.patients.filter(patient =>
      patient.name.toLowerCase().includes(this.searchText.toLowerCase())
    );
  }
}
deletePatient(id: number) {
  this.PatientService['deletePatient'](id).subscribe((data: any) => {
    console.log(data);
    this.GetPatients();
  } ); 
}
logout(){
  this.AdminauthService.logout();
  this.router.navigate(['home'])

}

}

    
    
    

    



