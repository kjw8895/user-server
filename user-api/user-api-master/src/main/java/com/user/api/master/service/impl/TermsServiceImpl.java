package com.user.api.master.service.impl;

import com.user.api.master.application.dto.TermsDto;
import com.user.api.master.service.TermsService;
import com.user.common.code.TermsType;
import com.user.core.domain.AttachmentFileEntity;
import com.user.core.domain.TermsEntity;
import com.user.core.repository.TermsEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TermsServiceImpl implements TermsService {
    private final TermsEntityRepository termsEntityRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TermsEntity> findAllByType(TermsType type) {
        return termsEntityRepository.findAllByType(type);
    }

    @Override
    @Transactional
    public TermsEntity create(TermsDto.Request request, AttachmentFileEntity attachmentFile) {
        TermsEntity entity = TermsEntity.toEntity(request.getType(), attachmentFile);
        return termsEntityRepository.save(entity);
    }
}
