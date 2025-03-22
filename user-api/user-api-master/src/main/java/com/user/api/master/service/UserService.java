package com.user.api.master.service;

import com.user.core.application.command.UserCommand;
import com.user.core.domain.UserEntity;

import java.util.Optional;

public interface UserService {
    Optional<UserEntity> findByEmail(String email);
    UserEntity createUser(UserCommand command);
}
