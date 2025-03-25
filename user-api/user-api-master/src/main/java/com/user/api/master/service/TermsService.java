package com.user.api.master.service;

import com.user.api.master.application.dto.TermsDto;
import com.user.common.code.TermsType;
import com.user.core.domain.AttachmentFileEntity;
import com.user.core.domain.TermsEntity;

import java.util.List;

public interface TermsService {
    List<TermsEntity> findAllByType(TermsType type);
    TermsEntity create(TermsDto.Request request, AttachmentFileEntity attachmentFile);
}
