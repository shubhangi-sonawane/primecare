import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminauthService {

  constructor() { }
  authenticate(username2:string,password2:string){
    if(username2=='sachin'&& password2=='5678'){
      sessionStorage.setItem('username2',username2);
      return true
    }
    else{
     return false
    }
  }
  isUserLoggedIn(){
    console.log("user login succesfully")
    let user=sessionStorage.getItem('username2');
    return !(user==null)
  }
  logout(){
    console.log("user logout")
    sessionStorage.removeItem('username2');
  }
}
