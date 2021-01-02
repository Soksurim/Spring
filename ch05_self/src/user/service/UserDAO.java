package user.service;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserDAO {
	
	public void insertInfo(UserDTO userDTO);

	public List<UserDTO> getUserList();

	public Map<String, Object> getUser(String id);

	public void modify(Map<String, Object> map);

	public void delete(String id);

}
