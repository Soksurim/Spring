
package user.bean;

import org.springframework.stereotype.Component;

import lombok.Setter;

@Setter
@Component
public class UserDTO {
	
	String name;
	String id;
	String pwd;

}
