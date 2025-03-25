package com.user.api.master.facade;

import com.user.api.master.application.dto.TermsDto;
import com.user.common.code.TermsType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TermsFacade {
    List<TermsDto.Response> findByType(TermsType type);
    void create(TermsDto.Request request, MultipartFile file);
}
