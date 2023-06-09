package io.heling.swiftshop.domain.response;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/27 14:34
 * @description
 */
public class ResponseMessageBuilder {
    public static <T> ResponseMessage<T> build(Integer code, T body){
        return new ResponseMessage<T>(code, body);
    }

    public static <T> ResponseMessage<T> build(Integer code){
        return new ResponseMessage<T>(code);
    }
}
