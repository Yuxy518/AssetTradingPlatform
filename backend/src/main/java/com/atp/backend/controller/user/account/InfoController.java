package com.atp.backend.controller.user.account;

import com.atp.backend.service.user.account.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: InfoController
 * @Author: Yuxy
 * @Description: api控制器层：由jwt获取用户信息
 * @DateTime: 2023/2/14 21:35
 **/

@RestController
public class InfoController {
	@Autowired
	private InfoService infoService;

	@GetMapping("/user/account/info/")
	public Map<String, String> getInfo() {
		return infoService.getInfo();
	}
}
