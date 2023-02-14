package com.atp.backend.controller;

import com.atp.backend.mapper.UserMapper;
import com.atp.backend.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: TestController
 * @Author: Yuxy
 * @Description: 测试
 * @DateTime: 2023/2/14 17:10
 **/

@RestController
@RequestMapping("/")
public class TestController {
	@Autowired
	UserMapper userMapper;

	@RequestMapping("user/all/")
	public List<User> test() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.ge("id", 1).le("id", 3);
		return userMapper.selectList(queryWrapper);
	}
}
