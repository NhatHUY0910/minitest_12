//package com.minitest_12.logger;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.NoSuchElementException;
//import java.util.logging.Logger;
//
//@Aspect
//@Component
//public class LoggingAspect {
//
//    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());
//
//    @AfterThrowing(pointcut = "execution(* com.minitest_12.service.computer.ComputerService.getById(..))", throwing = "ex")
//    public void logException(JoinPoint joinPoint, NoSuchElementException ex) {
//        logger.severe("Exception occurred in " + joinPoint.getSignature().toShortString() + ":" + ex.getMessage());
//    }
//
////    @AfterThrowing(pointcut = "execution(public * com.minitest_12.service.computer.ComputerService.*(..))", throwing = "ex")
////    public void logException(JoinPoint joinPoint, Exception ex) {
////        String className = joinPoint.getTarget().getClass().getSimpleName();
////        String methodName = joinPoint.getSignature().getName();
////        String args = Arrays.toString(joinPoint.getArgs());
////        System.out.printf("[CMS] co loi xay ra:  %s.%s%s: %s%n", className,methodName,args,ex.getMessage());
////    }
//}
