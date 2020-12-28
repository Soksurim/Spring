package sample02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cal")
@Scope("prototype")
public class Calculation implements Calc {

	private @Value(value = "24") int a;
	private @Value("36") int b;
	private int x, y;

	
	public Calculation(@Value("55") int x, @Value("77") int y) {
		System.out.println("Calculation2 생성자 실행");
		
		this.x = x;
		this.y = y;
		System.out.println("X : " + x);
		System.out.println("Y : " + y);
		
	}

	@Override
	public void calcAdd() {
		
		System.out.println(a + " + " + b + " = " + (a + b));
	}

	@Override
	public void calcAdd(@Value(value = "50") int a) {
		
		System.out.println(a + " + " + b + " = " + (a + b));
	}
	
	@Override
	public void calcAdd(int a, int b) {
		
		System.out.println(a + " + " + b + " = " + (a + b));
	}

	@Override
	public void calcMul(int a, int b) {
		System.out.println(a + " * " + b + " = " + (a * b));
		
	}

}
