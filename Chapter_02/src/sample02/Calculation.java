package sample02;

import lombok.Setter;


public class Calculation implements Calc {

	@Setter
	private int a;
	@Setter
	private int b;
	
	public Calculation() {
		System.out.println("Calculation_xml 생성자 실행");
	}
	
	public Calculation(int a, int b) {
		
		System.out.println("생성자 a : " + a);
		System.out.println("생성자 b : " + b);
	}	
	
	@Override
	public void calcAdd(int a, int b) {
		
		System.out.println(a + " + " + b + " = " + (a + b));
	}

	@Override
	public void calcMul(int a, int b) {
		System.out.println(a + " * " + b + " = " + (a * b));
		
	}

	@Override
	public void calcAdd() {
		System.out.println(a + " + " + b + " = " + (a + b));
		
	}

	@Override
	public void calcMul() {
		System.out.println(a + " * " + b + " = " + (a * b));
		
	}


}
