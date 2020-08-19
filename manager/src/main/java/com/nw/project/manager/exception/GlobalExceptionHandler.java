package com.nw.project.manager.exception;

import com.nw.project.common.dto.ResponseDTO;
import com.nw.project.common.enums.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常捕获处理
 * @author niwu
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseDTO handleExceptionHandler(Exception e, HttpServletRequest request) {
        log.error("catch Exception",e);
        return ResponseDTO.error(ErrorCode.FAIL);
    }
}
