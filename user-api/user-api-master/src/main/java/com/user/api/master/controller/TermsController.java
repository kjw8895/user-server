package com.user.api.master.controller;

import com.user.api.master.application.dto.TermsDto;
import com.user.api.master.facade.TermsFacade;
import com.user.common.code.TermsType;
import com.user.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/public/terms")
@RequiredArgsConstructor
public class TermsController {
    private final TermsFacade facade;

    @GetMapping
    public ResponseEntity<CommonResponse<List<TermsDto.Response>>> fetch(@RequestParam TermsType type) {
        List<TermsDto.Response> response = facade.findByType(type);

        return CommonResponse.ok(response);
    }
}
