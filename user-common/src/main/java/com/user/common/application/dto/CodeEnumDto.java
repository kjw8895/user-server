package com.user.common.application.dto;

import com.user.common.code.CodeEnum;

public record CodeEnumDto(
        String text,
        String code
) {
    public static CodeEnumDto toDto(CodeEnum codeEnum) {
        return new CodeEnumDto(codeEnum.getText(), codeEnum.getCode());
    }
}
