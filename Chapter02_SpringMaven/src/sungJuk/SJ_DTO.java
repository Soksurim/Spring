package sungJuk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import lombok.Data;

@ComponentScan("spring.conf")
@Data
public class SJ_DTO {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	@Override
	public String toString() {
		return name + "\t" 
			 + kor + "\t" 
			 + eng + "\t" 
			 + math + "\t" 
			 + tot + "\t" 
			 + String.format("%.2f", avg);
	}
}