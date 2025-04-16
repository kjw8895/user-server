package com.user.common.code;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CommonExceptionCode implements ExceptionCodeEnum {
    ACCESS_DENIED(1000, "Access denied.", HttpStatus.FORBIDDEN),
    UNKNOWN_SEVER_ERROR(1000, "Unknown server error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_REQUEST(1001, "Invalid request", HttpStatus.BAD_REQUEST),
    NOT_FOUND_RESOURCE(1002, "Not found resource", HttpStatus.NOT_FOUND),
    DATA_PARSING_ERROR(1003, "Data parsing error", HttpStatus.INTERNAL_SERVER_ERROR),
    FAIL_TO_WRITE_CSV_FILE(1004, "Fail to write csv file", HttpStatus.INTERNAL_SERVER_ERROR),
    UPLOAD_FILE_TO_S3_ERROR(1005, "Error while uploading file to Aws S3", HttpStatus.INTERNAL_SERVER_ERROR),
    DATA_READ_ERROR(1006, "Data read error", HttpStatus.INTERNAL_SERVER_ERROR),
    DATA_WRITE_ERROR(1007, "Data writing error", HttpStatus.INTERNAL_SERVER_ERROR),
    DATABASE_EXECUTE_ERROR(1008, "Database execute error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_API_KEY(1009, "Invalid api key", HttpStatus.BAD_REQUEST),
    MISSING_API_KEY(1010, "Api key is required", HttpStatus.BAD_REQUEST),
    CLIENT_NOT_FOUND(1011, "not found client", HttpStatus.BAD_REQUEST),
    USER_ALREADY_EXISTS(1012, "Email already exists", HttpStatus.BAD_REQUEST);

    private int code;
    private String msg;
    private HttpStatus httpStatus;

    CommonExceptionCode(int code, String msg, HttpStatus httpStatus) {
        this.code = code;
        this.msg = msg;
        this.httpStatus = httpStatus;
    }
}
