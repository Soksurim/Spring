package sungJuk;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SJ_Modify implements SungJuk {
	private List<SJ_DTO> list;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 이름 입력 : ");
		String name = scanner.next();
		
		int sw=0;
		for(SJ_DTO sungJukDTO : list) {
			if(sungJukDTO.getName().equals(name)) {
				sw=1;
				System.out.print("국어점수 입력: ");
				sungJukDTO.setKor(scanner.nextInt());
				System.out.print("영어점수 입력: ");
				sungJukDTO.setEng(scanner.nextInt());
				System.out.print("수학점수 입력: ");
				sungJukDTO.setMath(scanner.nextInt());
				sungJukDTO.setTot(sungJukDTO.getKor()
								 + sungJukDTO.getEng()
								 + sungJukDTO.getMath());
				sungJukDTO.setAvg(sungJukDTO.getTot() / 3.0);	
				
				System.out.println(name + "님의 데이터를 수정 하였습니다.");
			}
		}//for
		
		if(sw == 0)
			System.out.println("찾고자하는 이름이 없습니다.");
	}
}