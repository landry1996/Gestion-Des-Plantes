package net.plante.gestion_des_plantes;

import lombok.RequiredArgsConstructor;
import net.plante.gestion_des_plantes.dto.PlantDto;
import net.plante.gestion_des_plantes.services.PlantServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class GestionDesPlantesApplication implements CommandLineRunner {

    private final PlantServices plantServices;
    public static void main(String[] args) {
        SpringApplication.run(GestionDesPlantesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<PlantDto> plantDtos = new ArrayList<>(Arrays.asList(
    PlantDto.builder().name("Alo-Evera").species("Medecinale").image("IMG1").build(),
                PlantDto.builder().name("manguier").species("fruit").image("IMG2").build()

        ));
        for (PlantDto plantDto:plantDtos){
          plantServices.addPlant(plantDto);
        }
    }
}
