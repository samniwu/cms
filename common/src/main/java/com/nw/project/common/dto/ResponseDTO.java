package com.nw.project.common.dto;

import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nw.project.common.enums.ErrorCode;
import lombok.Data;

/**
 * 请求返回体
 * @author niwu
 */
@Data
@JSONType(orders = {"code","message","data"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO <T> {

    private String code;
    private String message;
    private T data;
    public ResponseDTO(){}

    public ResponseDTO(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public ResponseDTO (String code,String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseDTO (String code, String message, T value) {
        this.code = code;
        this.message = message;
        this.data = value;
    }

    public static <T> ResponseDTO<T> success(T value) {
        return new ResponseDTO<T>(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),value);
    }

    public static <Void> ResponseDTO<Void> error(ErrorCode errorCode) {
        return new ResponseDTO<>(errorCode);
    }

    public static <Void> ResponseDTO<Void> error(String code,String message) {
        return new ResponseDTO<>(code,message);
    }

}
