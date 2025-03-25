package com.user.api.master.facade.impl;

import com.user.api.master.application.dto.TermsDto;
import com.user.api.master.facade.TermsFacade;
import com.user.api.master.service.AttachmentFileService;
import com.user.api.master.service.TermsService;
import com.user.client.aws.s3.config.property.AwsS3Properties;
import com.user.common.code.TermsType;
import com.user.core.domain.AttachmentFileEntity;
import com.user.core.domain.TermsEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
@RequiredArgsConstructor
@EnableConfigurationProperties({AwsS3Properties.class})
@Slf4j
public class TermsFacadeImpl implements TermsFacade {
    private final TermsService termsService;
    private final AttachmentFileService attachmentFileService;
    private final AwsS3Properties awsS3Properties;

    @Override
    @Transactional
    public List<TermsDto.Response> findByType(TermsType type) {
        List<TermsEntity> termsList = termsService.findAllByType(type);

        return termsList.stream()
                .map(e -> TermsDto.Response.toResponse(e.getId(), e.getType(), e.getAttachmentFile().getFullUrl(awsS3Properties.getBaseUrl())))
                .toList();
    }

    @Override
    public void create(TermsDto.Request request, MultipartFile file) {
        try {
            AttachmentFileEntity entity = attachmentFileService.create(file);
            termsService.create(request, entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("Failed to create terms");
        }
    }
}
