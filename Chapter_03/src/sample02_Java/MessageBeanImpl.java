package sample02_Java;

public class MessageBeanImpl implements MessageBean {

	@Override
	public void study() {
		System.out.println("수업시간 공부");
	}

	@Override
	public String game() {
		System.out.println("수업시간  몰래 게임");
		return "바부팅이";
	}
}
