package cn.itcast.ssm.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	public User queryUserById(Integer userId) {
		SqlSession sqlSession = this.getSqlSession();
		Object user = sqlSession.selectOne("test.queryUserById", userId);
		return (User) user;
	}

	public void insertUser(User user) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("test.insertUser", user);
		
	}

}
