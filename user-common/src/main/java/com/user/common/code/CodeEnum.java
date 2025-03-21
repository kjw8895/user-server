package com.user.common.code;

public interface CodeEnum {
    String getText();

    default String getCode() {
        return toString();
    }
}
