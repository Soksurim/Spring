package user.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.annotation.ComponentScan;

import lombok.Setter;
import user.bean.UserDTO;

//@Service

@Setter
@ComponentScan("user.conf")
public class UserInsertService implements UserService {
	//@Autowired
	private UserDTO userDTO;
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name = null;
		String id = null;
		String pwd = null;
		
		try {
			
			//데이터
			System.out.print("이름 입력  : ");
			name = br.readLine();
			System.out.print("아이디 입력 : ");
			id = br.readLine();
			System.out.print("비밀번호 입력 : ");
			pwd = br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		//DB
		userDAO.insertInfo(userDTO);
		
		System.out.println(name);
		
		//응답
		System.out.println("데이터를 저장하였습니다");
	}

}










