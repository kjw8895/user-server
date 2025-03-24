package com.user.api.master.facade;

import com.user.api.master.application.dto.UserDto;

public interface UserFacade {
    UserDto.Response createUser(UserDto.Request request);
    boolean suspend(Long id);
}
