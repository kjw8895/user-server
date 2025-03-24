package com.user.core.repository;

import com.user.core.domain.UserStatusHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserStatusHistoryEntityRepository extends JpaRepository<UserStatusHistoryEntity, Long> {
    Optional<UserStatusHistoryEntity> findByUserIdAndActive(Long userId, Boolean active);
}
