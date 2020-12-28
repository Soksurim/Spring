package sample02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalcAdd implements Calc {
	private int x, y;

	public CalcAdd(@Value("25") int x, @Value("36") int y) {
		this.x = x;
		this.y = y;
		System.out.println("value 생성자");
	}

	@Override
	public void calcAdd() {
		System.out.println(x + " + " + y + " = " + (x+y));
		
	}

	@Override
	public void calcAdd(int x) {
		System.out.println(x + " + " + y + " = " + (x+y));
	}

	@Override
	public void calcAdd(int x, int y) {
		System.out.println(x + " + " + y + " = " + (x+y));
	}

	@Override
	public void calcMul(int x, int y) {
		System.out.println(x + " + " + y + " = " + (x+y));
	}

}
