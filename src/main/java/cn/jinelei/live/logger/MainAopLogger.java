package cn.jinelei.live.logger;

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
    public void controller(){}

//    MainController 环绕通知
    @Around("controller()")
    public void around(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println(String.format("\n>>>>>>>>>>>>>>>>>>>>>>> Before\t\tClass: %s\t\tMethod: %s\t\tArgs: %s", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
            joinPoint.proceed();
            System.out.println(String.format("<<<<<<<<<<<<<<<<<<<<<<< After \t\tClass: %s\t\tMethod: %s\n", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName()));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

//    创建切点 for websocket
//    @Pointcut(" execution(* cn.jinelei.live.websocket.*.*(..)) ")
//    public void websocket(){}
//
//    @Around("websocket()")
//    public void websocket(ProceedingJoinPoint joinPoint){
//        try {
//            System.out.println(String.format("\n>>>>>>>>>>>>>>>>>>>>>>> Before\t\tClass: %s\t\tMethod: %s\t\tArgs: %s", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
//            joinPoint.proceed();
//            System.out.println(String.format("<<<<<<<<<<<<<<<<<<<<<<< After \t\tClass: %s\t\tMethod: %s\n", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName()));
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//    }

}
