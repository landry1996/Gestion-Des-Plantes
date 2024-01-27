import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {PlanteserviceService} from "../services/planteservice.service";
import {Plant} from "../model/plant.model";

@Component({
  selector: 'app-new-plant',
  standalone: true,
  imports: [CommonModule,FormsModule,ReactiveFormsModule],
  templateUrl: './new-plant.component.html',
  styleUrl: './new-plant.component.css'
})
export class NewPlantComponent implements OnInit{

  plant!: Plant;
  newPlantFormGroup! : FormGroup;
  name: string = ''
  species: string=''
  image: string = '';
  purchaseDate: string = '';
  quantityWater: number = 0;
  wateringFrequency:number = 0;
  isWatering: boolean = false;
  constructor(private plantService: PlanteserviceService, private fb: FormBuilder) {
  }
  ngOnInit(): void {
    this.newPlantFormGroup =this.fb.group({
      name: this.fb.control(null,[Validators.required]),
      species:this.fb.control(null,[Validators.required]),
      purchaseDate:this.fb.control(null,[Validators.required]),
      image: this.fb.control(null,[Validators.required]),
      isWatering:this.fb.control(null,[Validators.required]),
      quantityWater: this.fb.control(null,[Validators.required]),
      wateringFrequency:this.fb.control(null,[Validators.required])
    });
   /*const image = this.newPlantFormGroup.get('/imagePlants/') as File
    this.saveImage(image)*/


  }
  /*saveImage(image){
    const imageName = image.name;
    const imageMimeType = image.type;
    const imagePath = '/imagePlants/' + imageName;
    image.saveAs(imagePath);
  }*/


  savePlant(){
  let plant: Plant = this.newPlantFormGroup.value
  this.plantService.addPlant(plant).subscribe({
    next: data =>{
      alert("Plant has been successfully saved")
    },error: err => {
      console.log(err)
    }
  });
  }

}
