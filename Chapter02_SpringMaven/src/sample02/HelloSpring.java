package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Calculation c = (Calculation) context.getBean("cal");
		
		
		c.calcAdd();
		c.calcAdd(33);
		c.calcAdd(66, 33);
		c.calcMul(66, 33);
		
		System.out.println("///");
		
		CalcAdd cadd = (CalcAdd) context.getBean("calcAdd");
		
		cadd.calcAdd();
	}

}
