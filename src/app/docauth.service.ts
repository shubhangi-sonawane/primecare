import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DocauthService {

  constructor() { }
  authenticate(username:string,password:string){
    if(username=="Advik"&&password=="1234"){
      sessionStorage.setItem('username',username);
      return true;
    }
    else{

      return false;
    

  }
  }
  isUserLoggedIn(){
    console.log("doctor login succesfully")
    let user=sessionStorage.getItem('username');
    console.log(user)
  
  return !(user==null)
  }
  logout(){
    console.log("doctor logout")
    sessionStorage.removeItem('username');
    
  }
}

