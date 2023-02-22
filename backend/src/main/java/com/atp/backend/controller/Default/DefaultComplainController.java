package com.atp.backend.controller.Default;

import com.atp.backend.service.api.Default.DefaultComplainService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: DefaultComplainController
 * @Author: Yuxy
 * @Description: 保存投诉信息接口，控制器层
 * @DateTime: 2023/2/22 10:10
 **/

@RestController
public class DefaultComplainController {
	@Autowired
	DefaultComplainService defaultComplainService;

	@PostMapping("/default/complain/")
	public Map<String, String> defaultComplain(@RequestParam Map<String, String> map) {
		Integer userId = CommonUtils.parseInt(map.get("userId"));
		String userName = map.get("userName");
		String userIdNum = map.get("userIdNum");
		String description = map.get("description");

		return defaultComplainService.defaultComplain(userId, userName, userIdNum, description);
	}
}
