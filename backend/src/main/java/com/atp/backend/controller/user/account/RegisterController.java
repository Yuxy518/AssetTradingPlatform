package com.atp.backend.controller.user.account;

import com.atp.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: RegisterController
 * @Author: Yuxy
 * @Description: api控制器：注册功能
 * @DateTime: 2023/2/14 21:38
 **/

@RestController
public class RegisterController {
	@Autowired
	RegisterService registerService;

	@PostMapping("/user/account/register/")
	public Map<String, String> register(@RequestParam Map<String, String> map) {
		String username = map.get("username");
		String password = map.get("password");
		String confirm_password = map.get("confirm_password");
		return registerService.register(username, password, confirm_password);
	}
}
