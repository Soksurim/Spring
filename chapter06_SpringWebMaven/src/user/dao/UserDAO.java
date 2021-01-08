package user.dao;

import java.util.List;

import user.bean.UserDTO;

public interface UserDAO {

	public void write(UserDTO userDTO);

	public UserDTO checkId(String id);

	public List<UserDTO> getList();

	public void modify(UserDTO userDTO);

}
