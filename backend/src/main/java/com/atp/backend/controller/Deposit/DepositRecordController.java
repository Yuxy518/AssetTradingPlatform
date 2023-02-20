package com.atp.backend.controller.Deposit;

import com.atp.backend.service.Deposit.DepositRecordService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: DepositRecordController
 * @Author: Yuxy
 * @Description: 获取支付定金记录，控制器层
 * @DateTime: 2023/2/20 16:21
 **/

@RestController
public class DepositRecordController {
	@Autowired
	DepositRecordService depositRecordService;

	@GetMapping("/deposit/record/")
	public Map<String, String> depositRecord(@RequestParam Map<String, String> map) {
		Integer userId = CommonUtils.parseInt(map.get("userId"));
		return depositRecordService.depositRecord(userId);
	}
}
