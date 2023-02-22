package com.atp.backend.controller.user;

import com.atp.backend.service.api.user.AllRecordService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: AllRecordController
 * @Author: Yuxy
 * @Description: 获得所有记录接口，控制器层
 * @DateTime: 2023/2/22 15:03
 **/

@RestController
public class AllRecordController {
	@Autowired
	AllRecordService allRecordService;

	@GetMapping("/user/record/")
	public Map<String, String> allRecord(@RequestParam Map<String, String> map) {
		Integer userId = CommonUtils.parseInt(map.get("userId"));
		return allRecordService.allRecordService(userId);
	}
}
