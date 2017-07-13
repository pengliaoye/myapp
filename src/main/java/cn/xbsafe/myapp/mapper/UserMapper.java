package cn.xbsafe.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.xbsafe.myapp.bean.User;

@Mapper
public interface UserMapper {

	User findByName(String name);
	
	List<User> findAll();
	
	void save(User user);

}
