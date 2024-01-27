import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {PlanteserviceService} from "../services/planteservice.service";
import {catchError, Observable, throwError} from "rxjs";
import {Plant} from "../model/plant.model";

@Component({
  selector: 'app-plante',
  standalone: true,
  imports: [CommonModule,FormsModule,ReactiveFormsModule],
  templateUrl: './plante.component.html',
  styleUrl: './plante.component.css'
})
export class PlanteComponent implements OnInit{


  plant! : Observable<Array<Plant>>
  errorMessage! : object;
  searchFormGroup! : FormGroup;
  constructor(private plantService: PlanteserviceService, private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.searchFormGroup = this.fb.group({
      keyword: this.fb.control("")
    });
    this.handleSearchPlant()
    this.plant = this.plantService.getAllPlants().pipe(
      catchError(err => {
        this.errorMessage = err.message;
        return throwError(err);
      })
    );
  }

  getAllPlant(){
    this.plant = this.plantService.getAllPlants().pipe(
      catchError(err => {
        this.errorMessage = err.message;
        return throwError(err);
      })
    );
  }

  handleSearchPlant() {

    let kw = this.searchFormGroup.value.keyword;
    this.plant = this.plantService.searchPlant(kw).pipe(
      catchError(err => {
        this.errorMessage = err.message;
        return throwError(err);
      })
    );
  }

  setDeletePlant(p:Plant){
    this.plantService.deletePlant(p.id).subscribe({
      next:(data)=>{
        alert("Employee Deleted")
        this.getAllPlant();
      },error: err => {
        console.log(err)
      }
    });
  }
  setImage(id:number){
    this.plantService.getImage(id).subscribe({
      next:(data)=>{

      },error: err => {
        console.log(err)
      }
    })
  }


}
