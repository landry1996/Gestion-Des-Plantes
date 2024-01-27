package net.plante.gestion_des_plantes.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import net.plante.gestion_des_plantes.dao.PlantRepository;
import net.plante.gestion_des_plantes.dto.PlantDto;
import net.plante.gestion_des_plantes.error.PlantAlreadyExistException;
import net.plante.gestion_des_plantes.error.PlantErrorException;
import net.plante.gestion_des_plantes.error.PlantNotFoundException;
import net.plante.gestion_des_plantes.mapper.PlantMapper;
import net.plante.gestion_des_plantes.model.Plant;
import net.plante.gestion_des_plantes.services.PlantServices;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static net.plante.gestion_des_plantes.utils.Utils.PLANT_ALREADY_EXIST_IN_DATABASE;
import static net.plante.gestion_des_plantes.utils.Utils.PLANT_NOT_EXIST;

@Service
@RequiredArgsConstructor
public class PlantServicesImpl implements PlantServices {

    private final PlantRepository plantRepository;
    private final PlantMapper plantMapper;


    @Override
    public PlantDto addPlant(PlantDto plantDto) throws PlantAlreadyExistException {

        if (Objects.nonNull(plantDto) && Objects.nonNull(plantDto.getName())) {
            Optional<Plant> plant = plantRepository.findPlantsByName(plantDto.getName());
            if (plant.isPresent()) {
                throw new PlantAlreadyExistException(PLANT_ALREADY_EXIST_IN_DATABASE);
            }
        }

        Plant plant = plantRepository.save(plantMapper.mapPlantDtoToPlant(plantDto));
        return plantMapper.mapPlantToPlantDto(plant);
    }

    @Override
    public List<PlantDto> getListPlant() {

        return plantRepository.findAll()
                .stream()
                .map(plantMapper::mapPlantToPlantDto).toList();
    }

    @Override
    public Optional<PlantDto> getPlantById(Long Id) {
        return plantRepository.findPlantsById(Id)
                .map(plantMapper::mapPlantToPlantDto);
    }


    @Override
    public List<PlantDto> searchPlant(String keyword) throws PlantNotFoundException {
       /*List<PlantDto> plantDtos = new ArrayList<>();

        List<Plant> plants = plantRepository.findPlantsByNameOrSpeciesContaining(keyword);

        for (Plant plant : plants) {
            plantDtos.add(plantMapper.mapPlantToPlantDto(plant));
        }
        return plantDtos;*/

//        plantRepository.findPlantsByNameOrSpeciesContaining(keyword).forEach(plant -> {
//            plantDtos.add(plantMapper.mapPlantToPlantDto(plant));
//        });

       return  plantRepository
                .findByNameContains(keyword)
                .stream().map(plantMapper::mapPlantToPlantDto).toList();
    }

    @Override
    public void deletePlant(Long id) throws PlantErrorException, PlantNotFoundException {

        Plant plant = plantRepository.findById(id).orElseThrow(
                () -> new ProviderNotFoundException(PLANT_NOT_EXIST));
        plantRepository.delete(plant);
    }


    @Override
    public List<PlantDto> getHistoryWatering() {

        return plantRepository.findAll().stream()
                .filter(Plant::isWatering)
                .map(plantMapper::mapPlantToPlantDto)
                .collect(Collectors.toList());

    }


}
