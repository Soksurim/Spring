package sungJuk;

import java.util.List;

public class SJ_Output implements SungJuk {
	private List<SJ_DTO> list;
	
	public void setList(List<SJ_DTO> list) {
		this.list = list;
	}

	@Override
	public void execute() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		for(SJ_DTO data : list) {
			System.out.println(data);
		}//for

	}

}