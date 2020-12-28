package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Calculation c = (Calculation) context.getBean("calc");
		
		c.calcAdd();
		c.calcMul();
		c.calcAdd(66, 33);
		c.calcMul(66, 33);
	}

}