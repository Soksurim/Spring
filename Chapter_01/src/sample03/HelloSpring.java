package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
//		ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); // src를 기본으로 잡기 때문에 src를 생략해 경로를 단축시킬 수 있다.
			
		MessageBean messageBean = (MessageBean) context.getBean("messageBean"); // Object -> MessageBean 다운 캐스팅
		messageBean.sayHello("Spring");
		System.out.println();
		
		MessageBean messageBean2 = context.getBean(MessageBean.class); // 클래스 지정
		messageBean2.sayHello("Spring2");
		System.out.println();
		
		MessageBean messageBean3 = (MessageBean) context.getBean("mb"); // 설정한 name 으로 받기
		messageBean3.sayHello("Spring3");
		System.out.println();
		
		((AbstractApplicationContext) context).close(); // 안닫아줘도 된다.
	}

}



