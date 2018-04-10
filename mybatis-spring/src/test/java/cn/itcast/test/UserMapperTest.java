package cn.itcast.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.po.User;
import cn.itcast.ssm.po.UserExample;
import cn.itcast.ssm.po.UserExample.Criteria;

public class UserMapperTest {
	
	@Test
	public void queryUserByName(){
		//加载spring配置文件，创建spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		UserMapper mapper = (UserMapper) ac.getBean("userMapper");
		//创建辅助类对象
		UserExample example = new UserExample();
		Criteria cri = example.createCriteria();
		//调用方法
		cri.andUsernameLike("%婷%");
		List<User> list = mapper.selectByExample(example);
		for (User u : list) {
			System.out.println(u);
		}
	}
	
	@Test
	public void insertUser(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		UserMapper mapper = (UserMapper) ac.getBean("userMapper");
		//创建用户对象
		User user = new User();
		user.setUsername("小黄人");
		user.setSex("2");
		user.setBirthday(new Date());
		user.setAddress("信阳");
		mapper.insertSelective(user);
	}
	
}
