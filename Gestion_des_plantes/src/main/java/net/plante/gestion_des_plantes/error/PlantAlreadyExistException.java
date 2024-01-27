package net.plante.gestion_des_plantes.error;

public class PlantAlreadyExistException extends Exception{


    public PlantAlreadyExistException(String message){
        super(message);
    }
}
