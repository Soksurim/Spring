package user.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import user.bean.UserDTO;
import user.dao.UserDAOMybatis;
import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserService;
import user.service.UserUpdateService;

@Configuration
public class SpringConfiguration {
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		basicDataSource.setUsername("c##java");
		basicDataSource.setPassword("bit");
		basicDataSource.setMaxTotal(20);
		basicDataSource.setMaxIdle(3);

		return basicDataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));
		
		sqlSessionFactoryBean.setConfigLocation(
				new DefaultResourceLoader().getResource("classpath:spring/mybatis-config.xml") );
		
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public UserDTO userDTO() {
		return new UserDTO();
	}

	@Bean
	public UserDAOMybatis userDAOMybatis() throws Exception {
		UserDAOMybatis userDAOMybatis = new UserDAOMybatis();
		userDAOMybatis.setSqlSession(sqlSession());
		return userDAOMybatis;
	}

	@Bean
	public UserInsertService userInsertService() throws Exception {
		UserInsertService userInsertService = new UserInsertService();
		userInsertService.setUserDTO(userDTO());
		userInsertService.setUserDAO(userDAOMybatis());
		return userInsertService;
	}

	@Bean
	public UserService userSelectService() throws Exception {
		UserSelectService userSelectService = new UserSelectService();
		userSelectService.setUserDAO(userDAOMybatis());

		return userSelectService;
	}

	@Bean
	public UserService userUpdateService() throws Exception {
		UserUpdateService userUpdateService = new UserUpdateService();
		userUpdateService.setUserDAO(userDAOMybatis());

		return userUpdateService;
	}

	@Bean
	public UserService userDeleteService() throws Exception {
		UserDeleteService userDeleteService = new UserDeleteService();
		userDeleteService.setUserDAO(userDAOMybatis());

		return userDeleteService;
	}
}
