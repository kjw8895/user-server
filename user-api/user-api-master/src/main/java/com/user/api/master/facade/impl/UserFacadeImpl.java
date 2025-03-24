package com.user.api.master.facade.impl;

import com.user.api.master.application.dto.UserDto;
import com.user.api.master.facade.UserFacade;
import com.user.api.master.service.RoleService;
import com.user.api.master.service.UserService;
import com.user.api.master.service.UserStatusHistoryService;
import com.user.client.redisson.service.RedissonClientService;
import com.user.common.application.dto.SmsVerificationDto;
import com.user.common.code.CommonExceptionCode;
import com.user.common.exception.CommonException;
import com.user.common.utils.ObjectMapperUtils;
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
    private final UserStatusHistoryService userStatusHistoryService;
    private final RedissonClientService redissonClientService;

    @Override
    @Transactional
    public UserDto.Response createUser(UserDto.Request request) {
        Object message = redissonClientService.get(request.getPhone());
        if (message == null) {
            throw new CommonException(CommonExceptionCode.INVALID_REQUEST);
        }

        SmsVerificationDto value = ObjectMapperUtils.readValue(message.toString(), SmsVerificationDto.class);
        if (!value.verify()) {
            throw new CommonException(CommonExceptionCode.INVALID_REQUEST);
        }

        UserCommand command = request.toCommand();

        Optional<UserEntity> exists = userService.findByEmail(request.getEmail());
        if (exists.isPresent()) {
            throw new CommonException(CommonExceptionCode.USER_ALREADY_EXISTS);
        }

        UserEntity user = userService.createUser(command);
        RoleEntity role = roleService.findByType(command.getRoleType()).orElseThrow(() -> new CommonException(CommonExceptionCode.INVALID_REQUEST));

        user.addRole(role);

        userStatusHistoryService.create(user, user.getStatus());

        return UserDto.Response.toDto(user);
    }

    @Override
    @Transactional
    public boolean suspend(Long id) {
        UserEntity user = userService.findById(id).orElseThrow(() -> new CommonException(CommonExceptionCode.INVALID_REQUEST));
        user.suspend();

        userStatusHistoryService.create(user, user.getStatus());

        return true;
    }
}
