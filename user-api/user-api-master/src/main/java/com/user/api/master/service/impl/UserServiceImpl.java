package com.user.api.master.service.impl;

import com.user.api.master.service.UserService;
import com.user.common.code.CommonExceptionCode;
import com.user.common.exception.CommonException;
import com.user.core.application.command.UserCommand;
import com.user.core.domain.UserEntity;
import com.user.core.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userEntityRepository.findById(id);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userEntityRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public UserEntity createUser(UserCommand command) {
        return userEntityRepository.save(UserEntity.toEntity(command, passwordEncoder.encode(command.getPassword())));
    }

    @Override
    @Transactional
    public UserEntity updateUser(Long id, UserCommand command) {
        UserEntity user = userEntityRepository.findById(id).orElseThrow(() -> new CommonException(CommonExceptionCode.INVALID_REQUEST));
        user.update(command);

        return userEntityRepository.save(user);
    }

    @Override
    @Transactional
    public boolean updatePassword(Long id, String oldPassword, String newPassword) {
        UserEntity user = userEntityRepository.findById(id).orElseThrow(() -> new CommonException(CommonExceptionCode.INVALID_REQUEST));
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new CommonException(CommonExceptionCode.PASSWORD_NOT_MATCH);
        }

        user.updatePassword(passwordEncoder.encode(newPassword));
        userEntityRepository.save(user);
        return true;
    }
}
