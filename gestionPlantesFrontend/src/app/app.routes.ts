import { Routes } from '@angular/router';
import {AcceuilComponent} from "./acceuil/acceuil.component";
import {PlanteComponent} from "./plante/plante.component";
import {HistoriqueArrosageComponent} from "./historiquearrosage/historique-arrosage.component";
import {NewPlantComponent} from "./newplant/new-plant.component";


export const routes: Routes = [
  {path: "acceuil", component: AcceuilComponent},
  {path: "plante", component: PlanteComponent},
  {path: "historiquearrosage", component: HistoriqueArrosageComponent},
  {path: "newplant", component: NewPlantComponent}

];
