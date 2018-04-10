package cn.itcast.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.po.User;

public class UserDaoTest {
	
	@Test
	public void queryUserById(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		
		UserDao userDao =(UserDao)ac.getBean("userDao");
		
		User user = userDao.queryUserById(5);
		
		System.out.println(user);
	}
	
	@Test
	public void insertUser(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		//创建用户对象
		User user = new User();
		user.setUsername("");
		userDao.insertUser(user);
	}
}
