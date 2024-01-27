import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterLink, RouterOutlet} from '@angular/router';
import {HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet,RouterLink,HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  action: Array<any>=[

    {title:"Home", "route":"",icon:"house"},
    {title:"Acceuil", "route":"/acceuil",icon:"search"},
    {title:"Plante", "route":"/plante",icon:"search"},
    {title:"NEW PLANT", "route":"/newplant",icon:"safe"},
    {title:"Historique Arrosage", "route":"/historiquearrosage",icon:"safe"}
  ];

  currentAction: any ;

  setCurrentAction(act: any) {

    this.currentAction = act;

  }
}
