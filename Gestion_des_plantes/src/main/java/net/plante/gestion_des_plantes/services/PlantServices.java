package net.plante.gestion_des_plantes.services;

import net.plante.gestion_des_plantes.dto.PlantDto;
import net.plante.gestion_des_plantes.error.PlantAlreadyExistException;
import net.plante.gestion_des_plantes.error.PlantErrorException;
import net.plante.gestion_des_plantes.error.PlantNotFoundException;
import net.plante.gestion_des_plantes.model.Plant;

import java.util.List;
import java.util.Optional;

public interface PlantServices {

    PlantDto addPlant(PlantDto plantDto) throws PlantAlreadyExistException;
    List<PlantDto> getListPlant();
    Optional<PlantDto> getPlantById(Long id);
    List<PlantDto> searchPlant(String keyword) throws PlantNotFoundException;
    void deletePlant(Long id) throws PlantErrorException, PlantNotFoundException;
    List<PlantDto> getHistoryWatering();




}
