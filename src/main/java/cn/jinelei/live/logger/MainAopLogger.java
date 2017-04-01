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

//    count connection number
    @Pointcut(" execution(* cn.jinelei.live.websocket.SystemWebSocketHandler.afterConnectionEstablished(..)) ")
    public void websocketConnection(){}

//    @Before("websocketConnection()")
//    public void beforeWebSocketConnnection(JoinPoint joinPoint){
//        System.out.println(String.format("\n>>>>>>>>>>>>>>>>>>>>>>> Before\t\tClass: %s\t\tMethod: %s\t\tArgs: %s", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
//    }

    @After("websocketConnection()")
    public void afterWebSocketConnection(JoinPoint joinPoint){
        System.out.println(String.format("<<<<<<<<<<<<<<<<<<<<<<< After \t\tClass: %s\t\tMethod: %s\n", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName()));
    }

    @Pointcut(" execution(* cn.jinelei.live.websocket.SystemWebSocketHandler.afterConnectionClosed(..)) ")
    public void websocketConnectionClosed(){}

//    @Before("websocketConnectionClosed()")
//    public void beforeWebSocketConnnectionClosed(JoinPoint joinPoint){
//        System.out.println(String.format("\n>>>>>>>>>>>>>>>>>>>>>>> Before\t\tClass: %s\t\tMethod: %s\t\tArgs: %s", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
//    }

    @After("websocketConnectionClosed()")
    public void afterWebSocketConnectionClosed(JoinPoint joinPoint){
        System.out.println(String.format("<<<<<<<<<<<<<<<<<<<<<<< After \t\tClass: %s\t\tMethod: %s\n", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName()));
    }
    //    创建切点 for websocket
    @Pointcut(" execution(* cn.jinelei.live.websocket.*.*(..)) ")
    public void websocket(){}

    @Before("websocket()")
    public void beforeWebSocket(JoinPoint joinPoint){
        System.out.println(String.format("\n>>>>>>>>>>>>>>>>>>>>>>> Before\t\tClass: %s\t\tMethod: %s\t\tArgs: %s", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
    }

    @After("websocket()")
    public void afterWebSocket(JoinPoint joinPoint){
        System.out.println(String.format("<<<<<<<<<<<<<<<<<<<<<<< After \t\tClass: %s\t\tMethod: %s\n", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName()));
    }

}
