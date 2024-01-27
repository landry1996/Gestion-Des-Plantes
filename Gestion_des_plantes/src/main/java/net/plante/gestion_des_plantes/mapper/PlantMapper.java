package net.plante.gestion_des_plantes.mapper;

import net.plante.gestion_des_plantes.dto.PlantDto;
import net.plante.gestion_des_plantes.model.Plant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlantMapper {


    @Mapping(target = "name",source = "name")
    Plant mapPlantDtoToPlant(PlantDto plantDto);


    PlantDto mapPlantToPlantDto(Plant plant);
}
