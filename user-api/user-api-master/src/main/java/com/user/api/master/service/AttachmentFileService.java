package com.user.api.master.service;

import com.user.core.domain.AttachmentFileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface AttachmentFileService {
    Optional<AttachmentFileEntity> findById(Long id);
    AttachmentFileEntity create(MultipartFile file) throws IOException;
}
