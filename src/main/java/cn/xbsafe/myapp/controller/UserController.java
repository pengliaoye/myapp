package cn.xbsafe.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xbsafe.myapp.bean.User;
import cn.xbsafe.myapp.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public Object findAll() {
		return userService.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody User user){
		for(int i = 0; i< 10000; i++) {
			userService.save(user);
			user.setId(null);
		}
		System.out.println(user.getId());
	}

}
