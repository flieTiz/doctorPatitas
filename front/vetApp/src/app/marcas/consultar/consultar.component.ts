import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-consultar',
  templateUrl: './consultar.component.html',
  styleUrls: ['./consultar.component.css']
})
export class ConsultarComponent implements OnInit {

  infoConsulta:any;

  constructor(private http: HttpClient) { }
  
  ngOnInit(): void {
    this.listar();
  }

  listar():void{

    this.http.get("http://localhost:8080/api/veterinaria/consultar",{responseType:"json"})
    .subscribe((x:any)=>{
      console.log(x);
      this.infoConsulta=x;
    });

  }

  eliminar(x:any):void{
    alert(x);
  }

}
