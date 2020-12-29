package user.dao;

import java.util.List;

import user.bean.UserDTO;

public interface UserDAO {

	public void write(UserDTO userDTO);

	public List<UserDTO> getUserList();

	public List<UserDTO> findById(String id);

	public void updateUserInfo(UserDTO userDTO);

	public void deleteUserInfo(String id);

}
