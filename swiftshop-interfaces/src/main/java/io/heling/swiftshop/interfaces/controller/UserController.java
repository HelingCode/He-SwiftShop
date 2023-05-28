package io.heling.swiftshop.interfaces.controller;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import io.heling.swiftshop.application.service.UserService;
import io.heling.swiftshop.domain.code.ErrorCode;
import io.heling.swiftshop.domain.model.SwiftShopUser;
import io.heling.swiftshop.domain.response.ResponseMessage;
import io.heling.swiftshop.domain.response.ResponseMessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/28 10:24
 * @description
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMessage<SwiftShopUser> getUser(@RequestParam(value = "username") String userName) {
        return ResponseMessageBuilder.build(ErrorCode.SUCCESS.getCode(),userService.getUserByUserName(userName));
    }
}
