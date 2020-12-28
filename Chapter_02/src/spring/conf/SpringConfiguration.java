package spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample03.SungJukDTO;
import sample03.SungJukImpl;

@Configuration // 해당 클래스를 xml에서 읽어들일때 설정파일로써 인식하게 한다.
public class SpringConfiguration {

	// @Bean 어노테이션을 달아야 리턴되는 객체를 bean으로 인식해 getBean메소드로 호출이 가능하다.
	// 메소드명(getSungJukDTO)을 객체명으로 인식하므로 @Bean에서 name설정을 하지 않으면 호출할때 context.getBean("getSungJukDTO"); 이렇게 불러야 한다. 
	@Bean(name = "sungJukDTO")
	public SungJukDTO getSungJukDTO() {
		return new SungJukDTO();
	}
	
	@Bean(name = "sungJukImpl") 
	public SungJukImpl getSungJukImpl() {
		return new SungJukImpl();
	}
	
}
