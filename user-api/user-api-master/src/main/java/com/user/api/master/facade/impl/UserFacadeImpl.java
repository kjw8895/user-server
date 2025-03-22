package com.user.api.master.facade.impl;

import com.user.api.master.application.dto.UserDto;
import com.user.api.master.facade.UserFacade;
import com.user.api.master.service.RoleService;
import com.user.api.master.service.UserService;
import com.user.common.code.CommonExceptionCode;
import com.user.common.exception.CommonException;
import com.user.core.application.command.UserCommand;
import com.user.core.domain.RoleEntity;
import com.user.core.domain.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;
    private final RoleService roleService;

    @Override
    @Transactional
    public UserDto.Response createUser(UserDto.Request request) {
        UserCommand command = request.toCommand();

        Optional<UserEntity> exists = userService.findByEmail(request.getEmail());
        if (exists.isPresent()) {
            throw new CommonException(CommonExceptionCode.USER_ALREADY_EXISTS);
        }

        UserEntity user = userService.createUser(command);
        RoleEntity role = roleService.findByType(command.getRoleType()).orElseThrow(() -> new CommonException(CommonExceptionCode.INVALID_REQUEST));

        user.addRole(role);

        return UserDto.Response.toDto(user);
    }
}
