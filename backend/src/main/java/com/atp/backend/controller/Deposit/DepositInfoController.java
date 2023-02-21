package com.atp.backend.controller.Deposit;

import com.atp.backend.service.api.Deposit.DepositInfoService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: DepositInfoController
 * @Author: Yuxy
 * @Description: 保存支付信息接口，控制器层
 * @DateTime: 2023/2/20 15:33
 **/

@RestController
public class DepositInfoController {
	@Autowired
	DepositInfoService depositInfoService;

	@PostMapping("/deposit/info")
	public Map<String, String> depositInfo(@RequestParam Map<String, String> map) {
		Integer userId = CommonUtils.parseInt(map.get("userId"));
		String payerName = map.get("payerName");
		String payerIdNum = map.get("payerIdNum");
		String propertyNum = map.get("propertyNum");
		Double mount = CommonUtils.parseDouble(map.get("mount"));
		String remarks = map.get("remarks");

		return depositInfoService.depositInfo(userId, payerName, payerIdNum, propertyNum, mount, remarks);
	}
}
