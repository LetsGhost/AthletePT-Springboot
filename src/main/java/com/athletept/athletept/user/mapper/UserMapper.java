package com.athletept.athletept.user.mapper;

import com.athletept.athletept.user.dto.UserDto;
import com.athletept.athletept.user.entity.UserEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
@DecoratedWith(UserMapperDecorator.class) // enables password hashing step
public interface UserMapper {

    // Entity -> DTO: never expose password
    @Mapping(target = "password", ignore = true)
    UserDto toDto(UserEntity entity);

    // DTO -> Entity: id/createdAt managed by persistence; password handled in decorator
    @Mapping(target = "password", ignore = true)    // set in decorator after hashing
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserEntity toEntity(UserDto dto);

    // Partial update: ignore nulls to avoid overwriting existing values
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "password", ignore = true)    // set in decorator if present in dto
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(UserDto dto, @MappingTarget UserEntity entity);
}
