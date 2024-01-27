import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Plant} from "../model/plant.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PlanteserviceService {

  public host:string="http://localhost:2029/api"

  constructor(public http:HttpClient) { }

public addPlant(plant: Plant):Observable<Plant>{

  return this.http.post<Plant>(this.host+"/Plants",plant);
}

public getAllPlants():Observable<Array<Plant>>{

    return this.http.get<Array<Plant>>(this.host+"/listPlants")
}

public searchPlant(keyword: string):Observable<Array<Plant>>{
   return this.http.get<Array<Plant>>(this.host+"/searchPlant")
}

public deletePlant(id:number){
  return this.http.delete(this.host+"/delete/"+id)
}

public getHistoryWatering():Observable<Array<Plant>>{

    return this.http.get<Array<Plant>>(this.host+"gethistoryWatering")
}

public getImage(id: number){
    return this.http.get(this.host+"/imagePlants/"+id);
}

}
