import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

declare const Swal:any;
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private r:Router,private http: HttpClient) { }

  m:any={
    usu:"",
    contra:""
  }

  ngOnInit(): void {
    
  }

  iniciar():void{
       this.http.get("http://localhost:8080/api/datosDueño/consultaPorParametrosUsuario/"+this.m.usu+"/"+this.m.contra+"",{responseType:"json"})
       .subscribe((Res:any)=>{

          if(Res.length===0){
          console.log(Res);

               Swal.fire({
              position: 'center',
              icon: 'error',
              title: 'Usuario no existe',
              showConfirmButton: false,
              timer: 2000
            })
        }

      
        for(var x of Res){
          if(x.id===""||x.id===null){
              Swal.fire({
              position: 'center',
              icon: 'error',
              title: 'Usuario no existe',
              showConfirmButton: false,
              timer: 2000
            })
              
          }
          else{
            Swal.fire({
              position: 'center',
              icon: 'success',
              title: 'Bienvenido',
              showConfirmButton: false,
              timer: 1500
            })

            this.r.navigate(["/menu/consultar"]);


          }
        }


    })
    
  }

}
