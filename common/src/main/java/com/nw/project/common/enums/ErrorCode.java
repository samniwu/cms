package com.nw.project.common.enums;

/**
 * 错误码
 * @author niwu
 */
public enum ErrorCode {
    SUCCESS("000000","success"),
    PARAM_ERROR("100001","parameter check error"),
    LOGIN_ERROR("200001","user login error"),
    HTTP_REQUEST_ERROR("300001","http request fail"),
    FAIL("999999","service internal error");

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    protected void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    protected void setMessage(String message) {
        this.message = message;
    }

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
