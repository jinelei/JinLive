package cn.jinelei.live.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * Created by jinelei on 17-3-30.
 */
@Aspect
public class MainAopLogger {

    //    创建切点 controller
    @Pointcut(" execution(* cn.jinelei.live.controller.*.*(..)) ")
    public void controller() {
    }

    @Before("controller()")
    public void beforeController(JoinPoint joinPoint) {
        System.out.println(String.format("\n>>>>>>>>>>>>>>>>>>>>>>> Before\t\tClass: %s\t\tMethod: %s\t\tArgs: %s", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
    }

    @After("controller()")
    public void afterController(JoinPoint joinPoint) {
        System.out.println(String.format("<<<<<<<<<<<<<<<<<<<<<<< After \t\tClass: %s\t\tMethod: %s\n", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName()));
    }

    //    创建切点 websocket
    @Pointcut(" execution(* cn.jinelei.live.utils.websocket.*.*.*(..)) ")
    public void websocket() {
    }

    @Before("websocket()")
    public void beforeWebsocket(JoinPoint joinPoint) {
        System.out.println(String.format("\n>>>>>>>>>>>>>>>>>>>>>>> Before\t\tClass: %s\t\tMethod: %s\t\tArgs: %s", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
    }

    @After("websocket()")
    public void afterWebsocket(JoinPoint joinPoint) {
        System.out.println(String.format("<<<<<<<<<<<<<<<<<<<<<<< After \t\tClass: %s\t\tMethod: %s\n", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName()));
    }

}
