package com.user.api.master.service.impl;

import com.user.api.master.service.RoleService;
import com.user.common.code.RoleType;
import com.user.core.domain.RoleEntity;
import com.user.core.repository.RoleEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleEntityRepository roleEntityRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<RoleEntity> findByType(RoleType type) {
        return roleEntityRepository.findByType(type);
    }
}
