package net.plante.gestion_des_plantes.mapper;

import net.plante.gestion_des_plantes.dto.NotificationDto;
import net.plante.gestion_des_plantes.model.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface NotificationMapper {

    @Mapping(target = "name",source = "name")
    Notification mapNotificationDtoToNotification(NotificationDto notificationDto);
    NotificationDto mapNotificationToNotificationDto(Notification notification);
}
