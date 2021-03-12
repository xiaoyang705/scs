package com.hyh.code.interceptor;

import com.hyh.code.base.RetCode;
import com.hyh.code.base.RetResponse;
import com.hyh.code.utils.HttpServletResponseUtil;
import com.hyh.code.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @ClassName AuthorizationInterceptor
 * @Description TODO
 * @Author Admin
 * @Date 2021/3/10 23:59
 * @Version 1.0
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {

    static Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果访问的不是控制器,则跳出,继续执行下一个拦截器
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //请求URL
//        String url = request.getServletPath().toString();
//        // 访问全路径
//        String fullUrl = request.getRequestURL().toString();
//        log.info("【请求全路径为： 】", fullUrl);
//        //如果是登录则不拦截开始
//        if (url.contains("/user/login")) {
//            return true;
//        }
        //获取HTTP HEAD 中的TOKEN、进行鉴权
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            HttpServletResponseUtil.printJSON(response, RetResponse.makeRsp(RetCode.UNAUTHORIZED, "用户未登录，请登录后操作！"));
            return false;
        }
        //从redis中取value，如果为空，则登陆过期
        Object loginStatus = redisUtil.get(token);
        if( Objects.isNull(loginStatus)){
            HttpServletResponseUtil.printJSON(response, RetResponse.makeRsp(RetCode.RESCODE_LOGINEXPIRE, "登录过期!"));
            return false;
        }
        //value不匹配为在其他设备登录，解决多台设备登录异常
//        if (!loginStatus.equals(token)) {
//            HttpServletResponseUtil.printJSON(response, RetResponse.makeRsp(RetCode.CODE_LOGINOTHERADDR_ERROR, "登录过期!"));
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //do nothing
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //do nothing
    }
}
