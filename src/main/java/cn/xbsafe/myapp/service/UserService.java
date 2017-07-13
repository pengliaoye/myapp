package cn.xbsafe.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xbsafe.myapp.bean.User;
import cn.xbsafe.myapp.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<User> findAll() {		
		List<User> users = userMapper.findAll();
		return users;
	}
	
	public void save(User user) {
		userMapper.save(user);
	}

}
