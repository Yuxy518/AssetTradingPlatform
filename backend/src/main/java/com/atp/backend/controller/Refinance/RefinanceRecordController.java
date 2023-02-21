package com.atp.backend.controller.Refinance;

import com.atp.backend.service.api.Refinance.RefinanceRecordService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: RefinanceRecordController
 * @Author: Yuxy
 * @Description: 获取转按揭记录接口控制器层
 * @DateTime: 2023/2/20 10:11
 **/
@RestController
public class RefinanceRecordController {
	@Autowired
	RefinanceRecordService refinanceRecordService;

	@GetMapping("/refinance/record/")
	public Map<String, String> refinanceRecord(String userId) {
		Integer userId_int = CommonUtils.parseInt(userId);
		return refinanceRecordService.refinanceRecord(userId_int);
	}
}
