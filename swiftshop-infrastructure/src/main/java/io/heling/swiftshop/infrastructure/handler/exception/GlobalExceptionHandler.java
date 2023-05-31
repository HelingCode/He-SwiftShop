package io.heling.swiftshop.infrastructure.handler.exception;

import io.heling.swiftshop.domain.code.HttpCode;
import io.heling.swiftshop.domain.exception.SwiftShopException;
import io.heling.swiftshop.domain.response.ResponseMessage;
import io.heling.swiftshop.domain.response.ResponseMessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/31 14:23
 * @description
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 全局异常处理，统一返回状态码
     */
    @ExceptionHandler(SwiftShopException.class)
    public ResponseMessage<String> handleSeckillException(SwiftShopException e) {
        logger.error("服务器抛出了异常：{}", e);
        return ResponseMessageBuilder.build(e.getCode(), e.getMessage());
    }
    /**
     * 全局异常处理，统一返回状态码
     */
    @ExceptionHandler(Exception.class)
    public ResponseMessage<String> handleException(Exception e) {
        logger.error("服务器抛出了异常：{}", e);
        return ResponseMessageBuilder.build(HttpCode.SERVER_EXCEPTION.getCode(), e.getMessage());
    }
}