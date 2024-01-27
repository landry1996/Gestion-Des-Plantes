package net.plante.gestion_des_plantes.controller;

import lombok.RequiredArgsConstructor;
import net.plante.gestion_des_plantes.dao.PlantRepository;
import net.plante.gestion_des_plantes.dto.PlantDto;
import net.plante.gestion_des_plantes.error.PlantAlreadyExistException;
import net.plante.gestion_des_plantes.error.PlantErrorException;
import net.plante.gestion_des_plantes.error.PlantNotFoundException;
import net.plante.gestion_des_plantes.model.Plant;
import net.plante.gestion_des_plantes.services.PlantServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class PlantController {

    private final PlantServices plantServices;
    private final PlantRepository plantRepository;

@GetMapping(path =  "/imagePlants/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
   public byte[] image(@PathVariable(name = "id") Long id) throws IOException {
    var p = plantRepository.findById(id).get();
    String photoName = p.getImage();
    var file = new File(System.getProperty("Utilisateurs.home")+"/images/"+photoName+".jpg");
       Path path = Paths.get(file.toURI());
       return Files.readAllBytes(path);
   }

    @PostMapping(path = "/Plants")
   public ResponseEntity<PlantDto> createPlant(@RequestBody PlantDto plantDto) throws PlantAlreadyExistException {
        var addPlantDto = plantServices.addPlant(plantDto);
     return new ResponseEntity<>(addPlantDto, HttpStatus.CREATED);
   }

   @GetMapping(path = "/listPlants")
   public List<PlantDto> getListPlants(){

        List<PlantDto> plantDtos = plantServices.getListPlant();
    return plantDtos;
   }

   @GetMapping(path = "/searchPlant")
   public List<PlantDto> searchPlant(@RequestParam(name = "keyword",defaultValue = "") String keyword)
           throws PlantNotFoundException {

     List<PlantDto> searchPlantDto = plantServices.searchPlant(keyword);
     return searchPlantDto;
   }

   @DeleteMapping(path = "/delete/{id}")
   public ResponseEntity<Void> deletePlant(@PathVariable Long id) throws PlantNotFoundException, PlantErrorException {
   plantServices.deletePlant(id);
   return ResponseEntity.ok().build();
   }

   @GetMapping(path = "/gethistoryWatering")
   public List<PlantDto> historyWatering(){


    return plantServices.getHistoryWatering();
   }




}
