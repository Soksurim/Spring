package user.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
@ComponentScan("user.*")
public class UserSelectService implements UserService {
	private UserDAO userDAO;

	@Override
	public void execute() {
		List<UserDTO> list = userDAO.getUserList();
		System.out.println("[이름]\t[아이디]\t[비밀번호]");
		
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName()+"\t" + userDTO.getId()+"\t" + userDTO.getPwd());
		}//for
		
	}

}
