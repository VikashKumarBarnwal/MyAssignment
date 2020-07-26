/**
 * 
 */
package com.vks.xebia.app.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Admin
 *
 */
@Aspect
@Component
public class ArticleLoggingAspect {
	
	@Before(value = "execution(* com.vks.xebia.app.service.ArticleServiceImpl.*(..))")  
	public void beforeAdvice(JoinPoint joinPoint) {  
	System.out.println("Entring method:" + joinPoint.getSignature());  
	}
	
	@After(value = "execution(* com.vks.xebia.app.service.ArticleServiceImpl.*(..))")  
	public void afterAdvice(JoinPoint joinPoint) {  
	System.out.println("Exiting method:" + joinPoint.getSignature());  
	} 

}
