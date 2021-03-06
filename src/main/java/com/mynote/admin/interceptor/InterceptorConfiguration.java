package com.mynote.admin.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;

@Component
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(new LoginInterceptor());
        // 配置拦截的路径
        ir.addPathPatterns("/**");
        //ir.addPathPatterns("/api/**");
        //ir.addPathPatterns("/page/**");
        // 配置不拦截的路径
        ir.excludePathPatterns("/login.html");
        ir.excludePathPatterns("/api/dologin");
        ir.excludePathPatterns("/lib/**");
        ir.excludePathPatterns("/img/**");
        ir.excludePathPatterns("/css/**");
        ir.excludePathPatterns("/src/**");
        ir.excludePathPatterns("/res/**");
        ir.excludePathPatterns("/nej/**");

        // 还可以在这里注册其它的拦截器
        //registry.addInterceptor(new OtherInterceptor()).addPathPatterns("/**");
    }
}
