package spring.conf;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import sample03.SungJukDTO;
import sample03.SungJukImpl;
import sungJuk.HelloSpring;
import sungJuk.SJ_DTO;
import sungJuk.SJ_Delete;
import sungJuk.SJ_Input;
import sungJuk.SJ_Modify;
import sungJuk.SJ_Output;

@Configuration // 해당 클래스를 xml에서 읽어들일때 설정파일로써 인식하게 한다.
public class SpringConfiguration {

	// @Bean 어노테이션을 달아야 리턴되는 객체를 bean으로 인식해 getBean메소드로 호출이 가능하다.
	// 메소드명(getSungJukDTO)을 객체명으로 인식하므로 @Bean에서 name설정을 하지 않으면 호출할때 context.getBean("getSungJukDTO"); 이렇게 불러야 한다. 
//	@Bean(name = "sungJukDTO")
//	public SungJukDTO getSungJukDTO() {
//		return new SungJukDTO();
//	}
//	
//	@Bean(name = "sungJukImpl") 
//	public SungJukImpl getSungJukImpl() {
//		return new SungJukImpl();
//	}

	@Bean(name = "helloSpring")
	public HelloSpring getHelloSpring() {
		return new HelloSpring();
	}
	
	@Bean(name = "SJ_DTO")
	public SJ_DTO getSJ_DTO() {
		return new SJ_DTO();
	}
	
	@Bean(name = "SJ_Input")
	public SJ_Input getSJ_Input() {
		return new SJ_Input();
	}
	
	@Bean(name = "SJ_Output")
	public SJ_Output getSJ_Output() {
		return new SJ_Output();
	}
	
	@Bean(name = "SJ_Modify")
	public SJ_Modify getSJ_Modify() {
		return new SJ_Modify();
	}
	
	@Bean(name = "SJ_Delete")
	public SJ_Delete getSJ_Delete() {
		return new SJ_Delete();
	}
	
	@Bean(name = "list")
	public ArrayList<SJ_DTO> getList() {
		return new ArrayList<SJ_DTO>();
	}
}
