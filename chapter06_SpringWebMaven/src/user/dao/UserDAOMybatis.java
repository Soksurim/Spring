package user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

@Repository(value="userDAO")
@Transactional
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(UserDTO userDTO) {
		
		sqlSession.insert("userSQL.write", userDTO);
	}


	@Override
	public UserDTO checkId(String id) {
		
		return sqlSession.selectOne("userSQL.checkId", id);
	}


	@Override
	public List<UserDTO> getList() {
		
		return sqlSession.selectList("userSQL.getUserList");
	}


	@Override
	public void modify(UserDTO userDTO) {
		int su = sqlSession.update("userSQL.modify", userDTO);
		System.out.println("수정 :" + su);
		
	}

}

