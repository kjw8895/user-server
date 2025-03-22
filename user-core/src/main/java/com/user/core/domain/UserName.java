package com.user.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserName {
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 20)
    private String lastName;

    public static UserName of(String firstName, String lastName) {
        UserName userName = new UserName();
        userName.firstName = firstName;
        userName.lastName = lastName;

        return userName;
    }
}
