package user.service;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserDeleteService implements UserService {
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		
		Scanner scan = new Scanner(System.in);

		System.out.print("삭제 할 아이디 입력  : ");
		String id = scan.next();
		
		List<UserDTO> list = userDAO.findById(id);

		if (list == null || list.size() == 0) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
			return;
		}
		
		userDAO.deleteUserInfo(id);

		System.out.println("데이터를 삭제하였습니다.");
		

	}

}










