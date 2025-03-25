package com.user.core.repository;

import com.user.common.code.TermsType;
import com.user.core.domain.TermsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TermsEntityRepository extends JpaRepository<TermsEntity, Long> {
    List<TermsEntity> findAllByType(TermsType type);
}
