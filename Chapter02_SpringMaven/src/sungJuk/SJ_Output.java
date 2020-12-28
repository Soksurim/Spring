package sungJuk;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@ComponentScan("spring.conf")
public class SJ_Output implements SungJuk {
	@Autowired
	@Qualifier("list")
	private ArrayList<SJ_DTO> list;
	
//	public void setList(List<SJ_DTO> list) {
//		this.list = list;
//	}

	@Override
	public void execute() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		for(SJ_DTO data : list) {
			System.out.println(data);
		}//for

	}

}