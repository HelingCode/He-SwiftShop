package io.heling.swiftshop.interfaces.interceptor;

import io.heling.swiftshop.domain.code.HttpCode;
import io.heling.swiftshop.domain.constants.Constants;
import io.heling.swiftshop.domain.exception.SwiftShopException;
import io.heling.swiftshop.infrastructure.shiro.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/6/2 15:53
 * @description
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    private static final String USER_ID = "userId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userIdObj = request.getAttribute(USER_ID);
        if (userIdObj != null){
            return true;
        }
        String token = request.getHeader(Constants.TOKEN_HEADER_NAME);
        if (StringUtils.isEmpty(token)){
            throw new SwiftShopException(HttpCode.USER_NOT_LOGIN);
        }
        Long userId = JwtUtils.getUserId(token);
        if (userId == null){
            throw new SwiftShopException(HttpCode.USER_NOT_LOGIN);
        }
        HttpServletRequestWrapper authRequestWrapper = new HttpServletRequestWrapper(request);
        authRequestWrapper.setAttribute(USER_ID, userId);
        return true;
    }
}
