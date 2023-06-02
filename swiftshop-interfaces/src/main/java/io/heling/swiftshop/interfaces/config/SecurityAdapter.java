package io.heling.swiftshop.interfaces.config;

import io.heling.swiftshop.interfaces.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/6/2 16:09
 * @description
 */
@Configuration
public class SecurityAdapter implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns("/user/login");
    }
}
