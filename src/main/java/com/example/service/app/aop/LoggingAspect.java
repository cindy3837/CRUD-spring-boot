package com.example.service.app.aop;

/**
 * 进入方法时间戳
 */

import com.example.service.app.enums.LogTag;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
// 可以有多的AOP，並透過@Order()來控制執行順序
@Order(0)
@Slf4j
public class LoggingAspect {

    private Long startTime;
    /**
     * 方法结束时间戳
     */
    private Long endTime;

    //切面
    @Pointcut("execution(public * com.example.service.app.controller..*.*(..)) && !execution(* com.example.service.app.controller..*Def*.*(..))")
    public void loggerOutPointcut() {

    }

    @Around("loggerOutPointcut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        // 接收到請求，取出請求對象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 印出請求的內容
        startTime = System.currentTimeMillis();
        log.info("[{}] 請求 Url : {} ", LogTag.AOP, request.getRequestURL().toString());
        log.info("[{}] 請求方式 : {}", LogTag.AOP, request.getMethod());
        log.info("[{}] 請求控制器 : {}", LogTag.AOP, pjp.getSignature().getDeclaringTypeName());
        log.info("[{}] 請求方法 : {}", LogTag.AOP, pjp.getSignature().getName());
        log.info("[{}] 請求參數 : {}", LogTag.AOP, Arrays.toString(pjp.getArgs()));
        // 執行方法
        Object result = pjp.proceed();
        log.info("[{}] 請求結束時間： {} ", LogTag.AOP, LocalDateTime.now());
        log.info("[{}] 請求耗時：{}ms", LogTag.AOP, (System.currentTimeMillis() - startTime));
        // 處理完請求，返回內容
        log.info("[{}] 請求返回 : {}",  LogTag.AOP, result);
        return result;
    }


    @AfterThrowing(value = "loggerOutPointcut()", throwing = "throwable")
    public void doAfterThrowing(Throwable throwable) {
        // 保存異常
        log.error("[{}] 發生異常時間：{}", LogTag.AOP, LocalDateTime.now());
        log.error("[{}] 拋出異常：{}", LogTag.AOP, throwable.getMessage());
    }

}
