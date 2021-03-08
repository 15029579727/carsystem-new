package com.car.carsystem.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName UserLoginInterceptor
 * @Deacription インターセプターは、ユーザーが正常にログインしたかどうかを一律に判断するためにグローバルに使用されます。
 * @Author Administrator
 * @Date 2020/11/24 23:55
 * @Version 1.0
 **/
@Component
public class UserLoginInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(UserLoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // sessionを取得する
        HttpSession session = request.getSession();
        logger.info("sessionId:" + session.getId());
        // ユーザー情報を取得する
        Object userInfo = session.getAttribute("userInfo");
        //　ユーザーがログインしているかどうかを判断する
        if (userInfo != null) {
            return true;
        } else {
            //ログインページへ移動
            response.sendRedirect(request.getContextPath() + "/");    // 跳转到首页登录
            logger.info("ユーザーがログインしておらず、移動されています:" + request.getContextPath() + "/");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}