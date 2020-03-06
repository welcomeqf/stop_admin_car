package com.dkm.aop;

import com.dkm.constanct.CodeType;
import com.dkm.exception.ApplicationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author qf
 * @date 2020/3/6
 * @vesion 1.0
 **/
@Aspect
@Component
public class MyAspect {

   /**
    * 定义切点
    */
   @Around("@annotation(IsBean)")
   public Object before(ProceedingJoinPoint point) {

      System.out.println("进入AOP了，加强之前！");

      Object proceed = null;
      try {
         proceed = point.proceed(point.getArgs());
         System.out.println("执行了AOP");
      } catch (Throwable throwable) {
         throw new ApplicationException(CodeType.UNKNOWN_ERROR);
      }

      System.out.println("--------"+proceed);

      System.out.println("加强之后~");
      return proceed;
   }
}
