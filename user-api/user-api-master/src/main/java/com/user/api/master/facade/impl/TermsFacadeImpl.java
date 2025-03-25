package com.user.api.master.facade.impl;

import com.user.api.master.facade.TermsFacade;
import com.user.api.master.service.AttachmentFileService;
import com.user.api.master.service.TermsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TermsFacadeImpl implements TermsFacade {
    private final TermsService termsService;
    private final AttachmentFileService attachmentFileService;
}
