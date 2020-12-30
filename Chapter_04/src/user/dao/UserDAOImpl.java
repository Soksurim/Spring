package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import user.bean.UserDTO;

/*
 내가 직접 JdbcTmplate bean으로 생성하지 않겠다.
public class UserDAOImpl implements UserDAO {

	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void write(UserDTO userDTO) {

		String sql = "insert into usertable values(?,?,?)";

		jdbcTemplate.update(sql, userDTO.getName(), "123", userDTO.getPwd());
	}

}
*/

public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {

	@Override
	public void write(UserDTO userDTO) {

//		String sql = "insert into usertable values(?,?,?)";
//		getJdbcTemplate().update(sql, userDTO.getName(), "123", userDTO.getPwd());
		
		// NamedParameterJdbcDaoSupport를 상속받으면
		// NamedParameter를 쓸 수 있는데, 데이터를  DTO가 아닌 Map으로 받아야 한다.
		
		String sql = "insert into usertable values(:name, :id, :pwd)";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}

	@Override
	public List<UserDTO> getUserList() {
		
		String sql = "select * from usertable";
		
//		List<UserDTO> list =  getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
//		
//		for(int i = 0; i < list.size(); i++) {
//			for(int j = 0; j < list.size(); j++) {
//				if(list.get(i).getId().equals(list.get(j).getId()) && i != j) {
//					System.out.println("# id " + list.get(i).getId() + "가 중복이므로 랜덤넘버로 수정됩니다.");
//					
//					if(list.get(i).getName().equals(list.get(j).getName())) {
//						System.out.println("아이디까지 같으므로 삭제");
//						this.getJdbcTemplate().execute("delete usertable where id = '"+ list.get(i).getId() +"'and name = '" + list.get(i).getName() + "' ");
//					}else {
//						this.getJdbcTemplate().execute("update usertable set id = '" + ((int)(Math.random()*888) + 111) + "' where id = '"+ list.get(i).getId() +"'and name = '" + list.get(i).getName() + "' ");
//					}
//				}
//				break;
//			}
//		}
//		
		
		// rowMapper (인터페이스) 한 줄을 Map으로 받는다.
		
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		// UserDTO를 참조한 RowMapper(결과물 한 줄)를 한층한층 쌓아 Map을 만든다
	}

	@Override
	public List<UserDTO> findById(String id) {
		
		String sql = "select * from usertable where id = '"+ id + "'";
		
		UserDTO dto = getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		//UserDTO dto = (UserDTO) getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		System.out.println("dto로 받은  ID :" +dto.getId());
		System.out.println("dto로 받은  Name :" +dto.getName());
		System.out.println("dto로 받은  pwd :" +dto.getPwd());
		
		getJdbcTemplate().execute("insert into usertable values('" + ((int)(Math.random()*889) + 111) + "','" + ((int)(Math.random()*889) + 111) + "','" + ((int)(Math.random()*889) + 111) + "')");
		
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		
	}

	@Override
	public void updateUserInfo(UserDTO userDTO) {
		String sql = "update usertable set name = :name, pwd = :pwd where id = :id";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		int su = getNamedParameterJdbcTemplate().update(sql, map);
		System.out.println("su = " + su);
	}

	@Override
	public void deleteUserInfo(String id) {
		String sql = "delete from usertable where id = :id";
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		
		int su = getNamedParameterJdbcTemplate().update(sql, map);
		System.out.println("삭제성공? : " + su);
	}
	
    public int delete(String id) {
        String sql = "delete from usertable where id = ?";
        
        return getJdbcTemplate().update(sql, id);
    }
    
}

