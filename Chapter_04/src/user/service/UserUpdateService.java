package user.service;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserUpdateService implements UserService {

	private UserDTO userDTO;
	private UserDAO userDAO;

	@Override
	public void execute() {

		Scanner scan = new Scanner(System.in);

		System.out.print("수정할 아이디 입력  : ");
		String id = scan.next();

		List<UserDTO> list = userDAO.findById(id);

		if (list == null || list.size() == 0) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
			return;
		}

		for (UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());

		} // for

		System.out.println("수정할 이름 입력 :");
		String name = scan.next();
		System.out.println("수정할 비밀번호 입력 :");
		String pwd = scan.next();

		userDTO.setId(id);
		userDTO.setName(name);
		userDTO.setPwd(pwd);

		userDAO.updateUserInfo(userDTO);

		System.out.println("데이터를 수정하였습니다.");

	}

}
