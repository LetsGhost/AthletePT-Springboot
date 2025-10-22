package com.athletept.athletept.user.mapper;

import com.athletept.athletept.user.dto.UserDto;
import com.athletept.athletept.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(UserEntity userEntity);
    UserEntity toEntity(UserDto userDto);
}
