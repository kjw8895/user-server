package com.user.api.master.controller;

import com.user.common.annotation.CurrentUser;
import com.user.common.application.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping(value = "/test")
    public void test(@CurrentUser UserInfo user) {
        System.out.println("test");
    }

    @GetMapping(value = "/public")
    public void testv2(@CurrentUser UserInfo user) {
        System.out.println("testv2");
    }
}
