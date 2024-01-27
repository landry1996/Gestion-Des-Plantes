package net.plante.gestion_des_plantes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlantDto {

    private Long id;
    private String name;
    private String species;
    private LocalDate purchaseDate;
    private String image;

}
