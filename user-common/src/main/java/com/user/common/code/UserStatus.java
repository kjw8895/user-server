package com.user.common.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStatus implements CodeEnum {
    ACTIVATE("ACTIVATE"),
    DORMANCY("DORMANCY"),
    WITHDRAWAL("WITHDRAWAL");

    private final String text;
}

