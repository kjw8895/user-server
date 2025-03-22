package com.user.api.master.application.dto;

import com.user.core.application.command.UserCommand;
import com.user.core.domain.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public abstract class UserDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor
    public static class Request {
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private String phone;

        public UserCommand toCommand() {
            return new UserCommand(this.email, this.password, this.firstName, this.lastName, this.phone);
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String email;
        private String phone;
        private List<RoleDto> roles;

        public static Response toDto(UserEntity entity) {
            Response response = new Response();
            response.id = entity.getId();
            response.email = entity.getEmail();
            response.roles = entity.getRoleEntities().stream().map(RoleDto::toDto).toList();

            return response;
        }
    }
}
