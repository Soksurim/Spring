package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void write(UserDTO userDTO) {
		userDAO.write(userDTO);		
	}

	@Override
	public String checkId(String id) {
		UserDTO userDTO = userDAO.checkId(id);
		
		if(userDTO == null) {
			return "사용 가능";
		}else {
			return "사용 불가능";
		}
	}

	@Override
	public List<UserDTO> getList() {
		
		List<UserDTO> list = userDAO.getList();
		
		return list;
	}

	@Override
	public UserDTO getUser(String id) {
		UserDTO userDTO = userDAO.checkId(id);
		
			return userDTO;
		
		
	}

	@Override
	public void modify(UserDTO userDTO) {
		userDAO.modify(userDTO);
	}

}
