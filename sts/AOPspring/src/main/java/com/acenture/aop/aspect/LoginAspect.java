package com.acenture.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoginAspect {
	
	//@Before(value ="execution(public void com.acenture.aop.service.TopicService addTopic())")
	@Before(value = "execution(* com.acenture.aop.service.TopicService.*())")
	public void logingAdvice()
	{
		System.out.println("Login advice executed");
	}

}
