package cn.itcast.ssm.dao;

import cn.itcast.ssm.po.User;

public interface UserDao {
	
	User queryUserById(Integer userId);
	
	
	void insertUser(User user);
}
