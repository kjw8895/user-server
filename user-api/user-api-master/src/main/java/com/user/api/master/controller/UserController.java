package com.user.api.master.controller;

import com.user.api.master.application.dto.UserDto;
import com.user.api.master.facade.UserFacade;
import com.user.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/{id}")
    public ResponseEntity<CommonResponse<UserDto.Response>> updateUser(@PathVariable Long id, @RequestBody UserDto.Request request) {
        UserDto.Response response = facade.updateUser(id, request);

        return CommonResponse.ok(response);
    }

    @PutMapping(value = "/{id}/suspend")
    public ResponseEntity<CommonResponse<Boolean>> suspend(@PathVariable Long id) {
        boolean result = facade.suspend(id);

        return CommonResponse.ok(result);
    }

    @PutMapping(value = "/{id}/withdrawal")
    public ResponseEntity<CommonResponse<Boolean>> withdrawal(@PathVariable Long id) {
        return null;
    }
}
