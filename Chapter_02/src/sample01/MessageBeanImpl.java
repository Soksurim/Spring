package sample01;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // 기본생성자
@RequiredArgsConstructor
public class MessageBeanImpl implements MessageBean {

	@NonNull //null값 허용 안함
	private String fruit;
	
	@Setter // cost와 qty의 setter만 필요하므로 여기에 놓는다. 전부 필요하면 클래스 위에 명시
	private int cost, qty;
	
	/*  롬복으로 @ 생성 했으므로 필요x
	public MessageBeanImpl() { System.out.println("웅웅이"); }
	
	//fruit만 받는 생성자 
	public MessageBeanImpl(String fruit) { super(); this.fruit = fruit; }
	
	// cost, qty를 받는 세터게터
	
	public void setCost(int cost) { this.cost = cost; }
	
	public void setQty(int qty) { this.qty = qty; }
	*/
	
	
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
