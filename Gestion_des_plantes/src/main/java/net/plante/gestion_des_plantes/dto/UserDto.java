package net.plante.gestion_des_plantes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.plante.gestion_des_plantes.dto.PlantDto;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private Collection<PlantDto> plantDtos = new ArrayList<>();
    private Collection<NotificationDto> notificationDtos = new ArrayList<>();
}
