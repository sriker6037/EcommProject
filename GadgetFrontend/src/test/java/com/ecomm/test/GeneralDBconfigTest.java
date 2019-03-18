package com.ecomm.test;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralDBconfigTest 
{
public static void main(String arg[])
{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.ecomm");
	context.refresh();
	SessionFactory sessionFactory= (SessionFactory)context.getBean("sessionFactory");
}
}
