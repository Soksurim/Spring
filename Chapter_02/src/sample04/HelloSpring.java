package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		System.out.println("0. Life Cycle");
		System.out.println("---------------------");
		System.out.println("ClassPathXmlApplicationContext");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("---------------------");
		MessageBean messageBean = (MessageBean) context.getBean("messageBeanImpl2");
		System.out.println("context.getBean(");
		messageBean.helloCall();

	}

}
