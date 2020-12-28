package sample01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mb")
public class MessageBeanImpl implements MessageBean {

	private @Value(value = "딸기") String fruit;
	private @Value("5000") int cost;
	private @Value("30") int qty;
	
	@Override
	public void sayHello() {
		System.out.println("과일명 : " + fruit + "\t 단가 : " + cost + "\t 개수 : " + qty);
	}

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println("과일명 : " + fruit + "\t 단가 : " + cost + "\t 개수 : " + qty);
	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println("과일명 : " + fruit + "\t 단가 : " + cost + "\t 개수 : " + qty);
	}

}
