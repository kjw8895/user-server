package com.user.common.application.dto;

import com.user.common.code.VerificationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SmsVerificationDto implements Serializable {
    private String code;
    private VerificationStatus status;

    public boolean verify() {
        return VerificationStatus.SUCCESS.equals(status);
    }
}

