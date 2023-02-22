package com.atp.backend.controller.Default;

import com.atp.backend.service.api.Default.DefaultRecordService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: DefaultRecordController
 * @Author: Yuxy
 * @Description: 获取投诉记录接口，控制器层
 * @DateTime: 2023/2/22 10:27
 **/

@RestController
public class DefaultRecordController {
	@Autowired
	DefaultRecordService defaultRecordService;

	@GetMapping("/default/record/")
	public Map<String, String> defaultRecord(@RequestParam Map<String, String> map) {
		Integer userId = CommonUtils.parseInt(map.get("userId"));
		return defaultRecordService.defaultRecord(userId);
	}
}
