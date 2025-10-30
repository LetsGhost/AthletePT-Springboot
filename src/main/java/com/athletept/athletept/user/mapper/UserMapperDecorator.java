package com.athletept.athletept.user.mapper;

import com.athletept.athletept.user.dto.UserDto;
import com.athletept.athletept.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class UserMapperDecorator implements UserMapper {

    @Qualifier("delegate")
    private final UserMapper delegate;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto toDto(UserEntity entity) {
        return delegate.toDto(entity);
    }

    @Override
    public UserEntity toEntity(UserDto dto) {
        UserEntity entity = delegate.toEntity(dto);
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        return entity;
    }

    @Override
    public void updateEntityFromDto(UserDto dto, UserEntity entity) {
        delegate.updateEntityFromDto(dto, entity);
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
    }
}
