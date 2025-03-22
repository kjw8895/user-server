package com.user.core.repository;

import com.user.common.code.RoleType;
import com.user.core.domain.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByType(RoleType type);
}
