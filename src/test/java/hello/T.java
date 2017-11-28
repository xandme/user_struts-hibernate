package hello;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T {
	private ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	public void test1(){
		SessionFactory sf=(SessionFactory) context.getBean("sessionFactory");
	}
}
