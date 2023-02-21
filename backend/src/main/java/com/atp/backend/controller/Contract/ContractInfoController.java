package com.atp.backend.controller.Contract;

import com.atp.backend.service.api.Contract.ContractInfoService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: ContractInfoController
 * @Author: Yuxy
 * @Description: 保存合同信息接口，控制器层
 * @DateTime: 2023/2/20 18:35
 **/

@RestController
public class ContractInfoController {
	@Autowired
	ContractInfoService contractInfoService;

	@PostMapping("/contract/info/")
	public Map<String, String> contractInfo(@RequestParam Map<String, String> map) {
		Integer userId = CommonUtils.parseInt(map.get("userId"));
		String sellerName = map.get("sellerName");
		String sellerIdNum = map.get("sellerIdNum");
		String buyerName = map.get("buyerName");
		String buyerIdNum = map.get("buyerIdNum");
		String propertyNum = map.get("propertyNum");
		String remarks = map.get("remarks");

		return contractInfoService.contractInfo(userId, sellerName, sellerIdNum, buyerName, buyerIdNum, propertyNum, remarks);
	}
}
