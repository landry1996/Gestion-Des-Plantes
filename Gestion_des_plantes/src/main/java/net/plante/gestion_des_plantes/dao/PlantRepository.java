package net.plante.gestion_des_plantes.dao;

import net.plante.gestion_des_plantes.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    Optional<Plant> findPlantsByName(String name);
    Optional<Plant> findPlantsById(Long id);
    //List<Plant> findPlantsByNameOrSpeciesContaining(String keyWord);
    List<Plant> findByNameContains(String keyword);

}
