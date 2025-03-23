package com.user.api.master.controller;

import com.user.api.master.application.dto.UserDto;
import com.user.api.master.facade.UserFacade;
import com.user.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {
    private final UserFacade facade;

    @PostMapping(value = "/sign-up")
    public ResponseEntity<CommonResponse<UserDto.Response>> createUser(@RequestBody UserDto.Request request) {
        UserDto.Response response = facade.createUser(request);

        return CommonResponse.ok(response);
    }
}
