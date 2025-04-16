package com.user.api.master.controller;

import com.user.api.master.application.dto.UserDto;
import com.user.api.master.application.dto.UserUpdateDto;
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

    @PatchMapping(value = "/{id}/password")
    public ResponseEntity<CommonResponse<Boolean>> updatePassword(@PathVariable Long id, @RequestBody UserUpdateDto request) {
        boolean result = facade.updatePassword(id, request);

        return CommonResponse.ok(result);
    }

    @PatchMapping(value = "/{id}/suspend")
    public ResponseEntity<CommonResponse<Boolean>> suspend(@PathVariable Long id) {
        boolean result = facade.suspend(id);

        return CommonResponse.ok(result);
    }

    @PatchMapping(value = "/{id}/withdrawal")
    public ResponseEntity<CommonResponse<Boolean>> withdrawal(@PathVariable Long id) {
        return null;
    }
}
