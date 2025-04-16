package com.user.api.master.facade;

import com.user.api.master.application.dto.UserDto;
import com.user.api.master.application.dto.UserUpdateDto;

public interface UserFacade {
    UserDto.Response createUser(UserDto.Request request);
    UserDto.Response updateUser(Long id, UserDto.Request request);
    boolean updatePassword(Long id, UserUpdateDto request);
    boolean suspend(Long id);
}
