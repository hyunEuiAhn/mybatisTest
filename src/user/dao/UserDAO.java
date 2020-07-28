package user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private SqlSessionFactory sqlSessionFactory;
	public static UserDAO userDAO;
	
	public static UserDAO getInstance() {
		synchronized(UserDAO.class){
			if (userDAO == null) userDAO=new UserDAO();
		}
		return userDAO;
	}
	
	public UserDAO() {
		//InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int write(UserDTO userDTO) {
		int su=0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		su = sqlSession.insert("userSQL.write", userDTO);
		sqlSession.commit();
		sqlSession.close();
		return su;
	}

	public List<UserDTO> userList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.userList");
		sqlSession.close();
		return list;
	}

	public void delete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.userDelete", id);
		sqlSession.commit();
		sqlSession.close();
	}

	public void update(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.out.println("입력 전");
		sqlSession.update("userSQL.modify", userDTO);
		System.out.println("입력 ");

		sqlSession.commit();
		sqlSession.close();
	}

	public UserDTO check(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO check = sqlSession.selectOne("userSQL.check", id);
		sqlSession.close();
		return check;
	}

	public List<UserDTO> search(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = null;
		list= sqlSession.selectList("userSQL.userSearchList", map);
		sqlSession.close();
		return list;
	}
}
