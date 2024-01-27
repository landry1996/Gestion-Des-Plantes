import {Component, OnInit} from '@angular/core';
import {PlanteserviceService} from "../services/planteservice.service";
import {CommonModule} from "@angular/common";
import {catchError, Observable, throwError} from "rxjs";
import {Plant} from "../model/plant.model";

@Component({
  selector: 'app-historique-arrosage',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './historique-arrosage.component.html',
  styleUrl: './historique-arrosage.component.css'
})
export class HistoriqueArrosageComponent implements OnInit{

  plant! : Observable<Array<Plant>>;
  errorMessage! : object;
  constructor(private plantService: PlanteserviceService) {
  }
  ngOnInit(): void {

    this.plant = this.plantService.getHistoryWatering().pipe(
      catchError(err => {
        this.errorMessage = err.message;
        return throwError(err);
      })
    );
  }

}
