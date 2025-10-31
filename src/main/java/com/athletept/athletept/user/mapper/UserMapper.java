package com.athletept.athletept.user.mapper;

import com.athletept.athletept.user.dto.UserDto;
import com.athletept.athletept.user.entity.UserEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

    // Entity -> DTO: never expose password
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "uuid", source = "uuid")
    UserDto toDto(UserEntity entity);

    @Mapping(target = "password", ignore = true)
    List<UserDto> toDtoList(List<UserEntity> entities);

    // DTO -> Entity: id/createdAt managed by persistence; password handled in decorator
    @Mapping(target = "password", ignore = true)    // set in decorator after hashing
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserEntity toEntity(UserDto dto);


}
