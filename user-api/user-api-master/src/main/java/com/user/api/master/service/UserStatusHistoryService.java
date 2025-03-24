package com.user.api.master.service;

import com.user.common.code.UserStatus;
import com.user.core.domain.UserEntity;
import com.user.core.domain.UserStatusHistoryEntity;

public interface UserStatusHistoryService {
    UserStatusHistoryEntity create(UserEntity user, UserStatus userStatus);
}
