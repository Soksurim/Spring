package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); // src를 기본으로 잡기 때문에 src를 생략해 경로를 단축시킬 수 있다.
		Calc calc;
		
		calc = (Calc) context.getBean("calcA"); // xml파일에 설정한 id로 호출,  Object -> calcA 다운 캐스팅
		calc.calculate(3, 4);
		System.out.println();
		
		calc = (Calc) context.getBean("calcM");
		calc.calculate(3, 4);
		System.out.println();
		
	}

}



