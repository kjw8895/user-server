package com.user.api.master.service;

import com.user.api.master.application.dto.TermsDto;
import com.user.core.domain.TermsEntity;

public interface TermsService {
    TermsEntity create(TermsDto.Request request, Long attachmentFileId);
}
