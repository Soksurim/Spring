package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//핵심관심사항, Target
//@ComponentScan("spring.conf")
@Component
public class MessageBeanImpl implements MessageBean {
	private String str;

	// autowire로 자동으로 setter메소드가 호출되도록
	@Autowired
	public void setStr(@Value("Have a nice day!!") String str) {
		this.str = str;
	}

	@Override
	public void showPrintBefore() {
		System.out.println("showPrintBefore 메시지 = "+str);
	}

	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("viewPrintBefore 메시지 = "+str);
		
	}
	
	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter 메시지 = "+str);
	}

	@Override
	public void viewPrintAfter() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("viewPrintAfter 메시지 = "+str);
		
	}

	@Override
	public void display() {
		System.out.println("display 메시지 = "+str);
	}

	@Override
	public String showPrint2() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("showPrint 메시지! = "+str);
		
		return "## 리턴메세지 스프링";
	}

	@Override
	public void viewPrint2() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrint 메시지!! = "+str);		
	}

}




