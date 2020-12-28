package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MessageBean mb = (MessageBean) context.getBean("mb");
		mb.sayHello();
		mb.sayHello("포도", 132);
		mb.sayHello("감자", 123, 1245);
	}

}
