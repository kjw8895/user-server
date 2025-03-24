package com.user.api.master.service.impl;

import com.user.api.master.service.UserStatusHistoryService;
import com.user.common.code.UserStatus;
import com.user.core.domain.UserEntity;
import com.user.core.domain.UserStatusHistoryEntity;
import com.user.core.repository.UserStatusHistoryEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserStatusHistoryServiceImpl implements UserStatusHistoryService {
    private final UserStatusHistoryEntityRepository userStatusHistoryEntityRepository;

    @Override
    @Transactional
    public UserStatusHistoryEntity create(UserEntity user, UserStatus userStatus) {
        userStatusHistoryEntityRepository.findByUserIdAndActive(user.getId(), true)
                .ifPresent(e -> {
                    e.end();
                    userStatusHistoryEntityRepository.save(e);
                });

        UserStatusHistoryEntity entity = UserStatusHistoryEntity.toEntity(user, userStatus);
        return userStatusHistoryEntityRepository.save(entity);
    }
}
