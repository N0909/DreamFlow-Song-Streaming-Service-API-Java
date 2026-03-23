package com.dreamflow.api.aspects;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("execution(* com.dreamflow.api.service.implementation.SongServiceImpl.getSongs())")
	public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("called {}", joinPoint.getSignature().getName());
		
		Object result = joinPoint.proceed();
		
		logger.info("called {}", joinPoint.getSignature().getName());
		
		return result;
	}
	
//	@After("execution(* com.dreamflow.api.service.implementation.SongServiceImpl.getSongs())")
//	public void logAfterMethod(JoinPoint joinPoint) {
//		logger.info("executed {}", joinPoint.getSignature().getName());
//	}
}
