package com.jpa2.demo.aop;


import java.util.Arrays;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class AccessAccept {

	private Logger log=LoggerFactory.getLogger(AccessAccept.class);
	
	@Before("execution(* com.jpa2.service.CollegeImpl.*(..))")
	public void before(JoinPoint joinpoint) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		log.info("Before Execution :Method Calling:"+joinpoint.getSignature().getName()+"():");
		Object[] obj=joinpoint.getArgs();
		log.info("Value passing in argument"+mapper.writeValueAsString(obj));
	}

	/*
	@After(value = "execution(* com.jpa2.service.CollegeImpl.*(..))")
	public void after(JoinPoint joinpoint) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		log.info("After Execution:Method called:"+joinpoint.getSignature().getName()+"()");
		Object[] obj=joinpoint.getArgs();
		log.info("Value passed in argument"+mapper.writeValueAsString(obj));
	}
	*/
	
	@AfterReturning(pointcut = "execution(* com.jpa2.service.CollegeImpl.*(..))",returning = "result")
	public void afterReturning(JoinPoint join,Object result) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		log.info("Method returned value is:"+mapper.writeValueAsString(result));
		//log.info("Method returning value is:"+result);
	}
	
	
	/*
	@Pointcut(value = "execution(* com.jpa2.service.CollegeImpl.*(..))")
	public void pointcut() {
		
	}
	
	@Around("pointcut()")
	public Object arround(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper=new ObjectMapper();
		String methodName=pjp.getSignature().getName();
		String className=pjp.getTarget().getClass().toString();
		Object[] arrays=pjp.getArgs();
		log.info("method invoked:"+className+"method name:"+methodName+"arguments:"+mapper.writeValueAsString(arrays));
		
		Object object=pjp.proceed();
		log.info(className+":"+methodName+"()"+"Response"+mapper.writeValueAsString(object));
		return object;
		
	}
	
	@AfterThrowing(value = "execution(* com.jpa2.service.CollegeImpl.*(..))",throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex) {
		log.info("After Throwing exception in method:"+joinPoint.getSignature());
		log.info("Exception :"+ex.getMessage());
	}
	*/
}
