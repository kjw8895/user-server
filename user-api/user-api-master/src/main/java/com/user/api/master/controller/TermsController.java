package com.user.api.master.controller;

import com.user.api.master.facade.TermsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/terms")
@RequiredArgsConstructor
public class TermsController {
    private final TermsFacade facade;
}
