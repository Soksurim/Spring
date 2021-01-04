package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@ComponentScan("user.*")
@Transactional
public class UserDAO_Mybatis implements UserDAO {
	@Setter
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertInfo(UserDTO userDTO) {
		sqlSession.insert("userSQL.insertInfo", userDTO);
	}

	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	}

	@Override
	public Map<String, Object> getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser", id);
	}

	@Override
	public void modify(Map<String, Object> map) {
		sqlSession.update("userSQL.modify", map);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);
	}
	
	
	
	
}














