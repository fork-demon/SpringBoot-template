package com.sapient.smarts.aop.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingApsect {

	
	private static final Logger logger = LogManager.getLogger(LoggingApsect.class);
	
	//@Pointcut("within(com.sapient.smart.controller..*)")
	@Pointcut("bean(*Controller)")
	private void logControllerMethods(){
		
	}
	
    @Before("logControllerMethods()")
	private void loggerMethodAtEntry(JoinPoint jp){
    	logger.debug("Executing method "+jp.getSignature().getDeclaringTypeName()+"."+ jp.getSignature().getName()+ " ....");
    	logArgs(jp);
    }
    
   
    @AfterReturning("logControllerMethods()")
    private void logMethodAfterExecComplete(JoinPoint jp){
    	logger.debug("Executed method "+jp.getSignature().getDeclaringTypeName()+"."+ jp.getSignature().getName()+" ....");
    	logArgs(jp);
    }
    
    private void logArgs(JoinPoint jp){
    	
    	if(jp.getArgs()!=null && jp.getArgs().length>0){
    		String argStr=" with Arguments: ";
    		for(Object object : jp.getArgs()){
    			argStr  = argStr + object.toString();
    		}
    		logger.debug(argStr);
    	}
    }
    
    @AfterThrowing(pointcut ="logControllerMethods()", throwing="error")
    private void logMethodMethodFailure(JoinPoint jp, Throwable error){
    	logger.error("Error occured in method "+jp.getSignature().getDeclaringTypeName()+"."+ jp.getSignature().getName());
    	logger.error("Error details: "+error);
    }
}
