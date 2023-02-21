package com.atp.backend.controller.Mortgage;

import com.atp.backend.service.api.Mortgage.MortgageRecordService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: MortgageRecordController
 * @Author: Yuxy
 * @Description: 按揭贷款记录接口，控制器层
 * @DateTime: 2023/2/21 20:26
 **/

@RestController
public class MortgageRecordController {
	@Autowired
	MortgageRecordService mortgageRecordService;

	@GetMapping("/mortgage/record/")
	public Map<String, String> mortgageRecord(@RequestParam Map<String, String> map) {
		Integer userId = CommonUtils.parseInt(map.get("userId"));
		return mortgageRecordService.mortgageRecord(userId);
	}
}
