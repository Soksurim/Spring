package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

/*
내가 직접 JdbcTemplate bean으로 생성하지 않겠다
public class UserDAOImpl implements UserDAO {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
	}

}
*/

//@Repository("userDAO")
@ComponentScan("user.conf")
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	
//	@Autowired
//	public void setDS(DataSource dataSource) {
//		setDataSource(dataSource);
//	}

	@Override
	public void write(UserDTO userDTO) {
		//String sql = "insert into usertable values(?,?,?)";
		//getJdbcTemplate().update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
		
		String sql = "insert into usertable values(:name,:id,:pwd)";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(
				sql,
				new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}
	
	/*
	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id=:id";
		
		try {
			return getJdbcTemplate().queryForObject(
					sql, 
					new BeanPropertyRowMapper<UserDTO>(UserDTO.class),
					id);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	*/
	
	public Map<String, Object> getUser(String id){
		String sql = "select * from usertable where id=:id";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
	
		try {
			map = getNamedParameterJdbcTemplate().queryForMap(sql, map);
		
		}catch(EmptyResultDataAccessException ex){
		   	map = null;
		}
		
		return map;
	}

	@Override
	public int getUserCount(String id) {
		String sql = "select count(*) from usertable where id=:id";
		return getJdbcTemplate().queryForObject(
				sql, 
				Integer.class,
				id);
	}

	@Override
	public void modify(Map<String, Object> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public void delete(String id) {
		String sql = "delete from usertable where id=:id";
		getJdbcTemplate().update(sql, id);
	}
}

























