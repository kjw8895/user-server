package com.user.api.master.service.impl;

import com.user.api.master.application.dto.TermsDto;
import com.user.api.master.service.TermsService;
import com.user.core.domain.TermsEntity;
import com.user.core.repository.TermsEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TermsServiceImpl implements TermsService {
    private final TermsEntityRepository termsEntityRepository;

    @Override
    @Transactional
    public TermsEntity create(TermsDto.Request request, Long attachmentFileId) {
        TermsEntity entity = TermsEntity.toEntity(request.getType(), attachmentFileId);
        return termsEntityRepository.save(entity);
    }
}
