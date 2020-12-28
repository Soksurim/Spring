package sungJuk;

import java.util.List;
import java.util.Scanner;

public class SJ_Input implements SungJuk {
	private SJ_DTO sungJukDTO;
	private List<SJ_DTO> list;
	
	public void setSungJukDTO(SJ_DTO sungJukDTO) {
		this.sungJukDTO = sungJukDTO;
	}

	public void setList(List<SJ_DTO> list) {
		this.list = list;
	}
	 
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scanner.next();
		System.out.print("국어점수 입력 : ");
		int kor = scanner.nextInt();
		System.out.print("영어점수 입력 : ");
		int eng = scanner.nextInt();
		System.out.print("수학점수 입력 : ");
		int math = scanner.nextInt();
			
		sungJukDTO.setName(name);      
		sungJukDTO.setKor(kor);
		sungJukDTO.setEng(eng);
		sungJukDTO.setMath(math);
		sungJukDTO.setTot(sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath());
		sungJukDTO.setAvg(sungJukDTO.getTot() / 3.0);
		

		list.add(sungJukDTO);
		   
		System.out.println(sungJukDTO.getName() + "님의 데이터를 입력 하였습니다.");
	}

}