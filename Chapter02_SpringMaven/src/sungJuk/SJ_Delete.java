package sungJuk;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import lombok.Setter;

@ComponentScan("spring.conf")
public class SJ_Delete implements SungJuk {
	@Autowired
	@Setter
	private List<SJ_DTO> list;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 이름 입력 : ");
		String name = scanner.next();
		
		int sw = 0;
		// 한 요소 삭제시 index가 밀리기 때문에 iterator를 쓴다.
		
		System.out.println("listsize : " + list.size());
		for(SJ_DTO data : list) {
			System.out.println("data.getName() : " +data.getName());
		}
		
		
		System.out.println("InputName : " +name);
		Iterator<SJ_DTO> it = list.iterator();
		
		while(it.hasNext()) {
			// 해당하는 항목이 있는지 찾아본다. 
			if(it.next().getName().equals(name)) {
				it.remove();
				sw=1;
				System.out.println(name + "님의 데이터를 삭제 하였습니다.");
			}
		}//while
		
		if(sw == 0) 
			System.out.println("찾고자하는 이름이 없습니다.");
	}

}