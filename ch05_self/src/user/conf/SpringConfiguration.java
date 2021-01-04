package user.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import user.aop.LoggingAdvice;
import user.bean.UserDTO;
import user.dao.UserDAO_Mybatis;
import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserService;
import user.service.UserUpdateService;

@Configuration // 해당 클래스를 xml에서 읽어들일때 설정파일로써 인식하게 한다.
@EnableAspectJAutoProxy
public class SpringConfiguration {

	// @Bean 어노테이션을 달아야 리턴되는 객체를 bean으로 인식해 getBean메소드로 호출이 가능하다.
	// 메소드명(getSungJukDTO)을 객체명으로 인식하므로 @Bean에서 name설정을 하지 않으면 호출할때
	// context.getBean("getSungJukDTO"); 이렇게 불러야 한다.

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

	// SQL
	@Bean
	SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));

		sqlSessionFactoryBean
				.setConfigLocation(new DefaultResourceLoader().getResource("classpath:spring/mybatis-config.xml"));

		sqlSessionFactoryBean.setDataSource(dataSource());

		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	//

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public UserDTO userDTO() {
		return new UserDTO();
	}

	@Bean
	public UserDAO_Mybatis userDAOMybatis() throws Exception {
		UserDAO_Mybatis userDAOMybatis = new UserDAO_Mybatis();
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
	
	@Bean
	public LoggingAdvice loggingAdvice() {
		return new LoggingAdvice();
	}

}
