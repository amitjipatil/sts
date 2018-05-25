package com.acenture.app.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoginAspect {
	
	//@Before(value ="execution(public void com.acenture.aop.service.TopicService addTopic())")
	@Before(value = "execution(* com.acenture.app.service.EmployeeService.*())")
	public void logingAdvice()
	{
		System.out.println("Login advice executed");
	}

}
