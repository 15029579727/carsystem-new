package com.car.carsystem.interceptor;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName LoginConfig
 * @Deacription インターセプター登録
 * @Author Administrator
 * @Date 2020/11/25 0:04
 * @Version 1.0
 **/

@EnableCaching
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    /**
     * このメソッドは、インターセプターを登録するために使用されます。
     * 複数のインターセプターを登録することができ、複数のインターセプターがインターセプターチェーンを形成する。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor())
                 // 静的リソースの傍受をしない
                .excludePathPatterns("/static/**")
                 // ログイン機能が傍受しない
                .excludePathPatterns("/login/loginUser")
                 // ログインページが傍受しない
                .excludePathPatterns("/");
    }
}