package com.atp.backend.service.impl.user.account;

import com.atp.backend.mapper.UserMapper;
import com.atp.backend.pojo.User;
import com.atp.backend.service.user.account.RegisterService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: RegisterService
 * @Author: Yuxy
 * @Description: 注册接口实现类
 * @DateTime: 2023/2/14 21:20
 **/

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	UserMapper userMapper;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Map<String, String> register(String username, String password, String confirm_password) {
		Map<String, String> map = new HashMap<>();
		username = username.trim();
		if(username.length() == 0) {
			map.put("error_message", "用户名不能为空");
			return map;
		}
		if(password.length() == 0){
			map.put("error_message", "密码不能为空");
			return map;
		}

		if(confirm_password.length() == 0) {
			map.put("error_message", "请再次输入密码");
			return map;
		}

		if(!password.equals(confirm_password)) {
			map.put("error_message", "两次输入的密码不一致");
			return map;
		}

		if(username.length() > 100 || password.length() > 100) {
			map.put("error_message", "用户名或密码的长度不能超过100");
			return map;
		}

		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", username);
		List<User> userList = userMapper.selectList(queryWrapper);

		if(userList.size() != 0){
			map.put("error_message", "昵称已被使用！");
			return map;
		}

		//加密密码
		String encodedPassword = passwordEncoder.encode(password);
		String photo = "https://cdn.acwing.com/media/user/profile/photo/60162_lg_3c98de95b9.png";

		//存到数据库
		User user = new User(null, username, encodedPassword, photo);
		userMapper.insert(user);

		map.put("error_message", "success");
		return map;
	}
}
