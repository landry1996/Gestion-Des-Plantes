package net.plante.gestion_des_plantes.mapper;

import net.plante.gestion_des_plantes.dto.UserDto;
import net.plante.gestion_des_plantes.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "name", source = "name")
    User mapUserDtoToUser(UserDto userDto);
    UserDto mapUserToUserDto(User user);
}
