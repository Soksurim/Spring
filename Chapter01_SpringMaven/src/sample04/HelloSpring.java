package sample04;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); // src를 기본으로 잡기 때문에 src를 생략해 경로를 단축시킬 수 있다.
		Calc calc;
		
		// bean xml파일로 생성
		calc = (Calc) context.getBean("calcA"); // xml파일에 설정한 id로 호출,  Object -> calcA 다운 캐스팅
		calc.calculate(3, 4);
		System.out.println();
		
		// bean 파일 어노테이션으로 생성
		calc = (Calc) context.getBean("calcM");
		calc.calculate(3, 4);
		System.out.println();
		
		List<String> list = (ArrayList<String>) context.getBean("arrayL"); // 일반 클래스를 xml생성해서 쓸 수도 있다.
		list.add("123");
		list.add("456");
		list.add("789");
		
		System.out.println("list.size() : " + list.size());
		for(String data : list) {
			System.out.println(data);
		}
		
	}

}



