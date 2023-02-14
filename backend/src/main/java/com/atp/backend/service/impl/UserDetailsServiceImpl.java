package com.atp.backend.service.impl;

import com.atp.backend.mapper.UserMapper;
import com.atp.backend.pojo.User;
import com.atp.backend.utils.UserDetailsImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserDetailsServiceImpl
 * @Author: Yuxy
 * @Description: 用来接入数据库信息
 * @DateTime: 2023/2/14 18:08
 **/

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", username);

		User user = userMapper.selectOne(queryWrapper);
		if(user == null) {
			throw new RuntimeException("用户不存在");
		}
		return new UserDetailsImpl(user);
	}
}
