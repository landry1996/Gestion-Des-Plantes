package net.plante.gestion_des_plantes.error;

public class PlantNotFoundException extends Exception{

    public PlantNotFoundException(String message){
        super(message);
    }
}
