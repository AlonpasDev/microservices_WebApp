import { Component } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';
import { Cliente } from 'src/app/model/Cliente';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  usuario:string;
  password:string;
  client:Cliente;

constructor(private loginService:LoginService){
}
login(){
  this.loginService.login(this.usuario,this.password).subscribe(data=>{
    this.client=data;
    if(this.client!=null){
      alert("usuario autenticado")
    }else{
      alert("usuario no autenticado")
    }
  }
  )
}
}
