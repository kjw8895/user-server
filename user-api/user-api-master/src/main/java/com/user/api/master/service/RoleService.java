package com.user.api.master.service;

import com.user.common.code.RoleType;
import com.user.core.domain.RoleEntity;

import java.util.Optional;

public interface RoleService {
    Optional<RoleEntity> findByType(RoleType type);
}
