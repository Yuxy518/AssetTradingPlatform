package com.atp.backend.controller.Mortgage;

import com.atp.backend.service.api.Mortgage.MortgageInfoService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: MortgageInfoController
 * @Author: Yuxy
 * @Description: 保存贷款信息接口，控制器层
 * @DateTime: 2023/2/21 18:06
 **/

@RestController
public class MortgageInfoController {
	@Autowired
	MortgageInfoService mortgageInfoService;

	@PostMapping("/mortgage/info/")
	public Map<String, String> mortgageInfo(@RequestParam Map<String, String> map) {
		Integer userId = CommonUtils.parseInt(map.get("userId"));
		String name = map.get("name");
		String idNum = map.get("idNum");
		String bankName = map.get("bankName");
		String bankId = map.get("bankId");
		String propertyNum = map.get("propertyNum");
		String remarks = map.get("remarks");

		return mortgageInfoService.mortgageInfo(userId, name, idNum, bankName, bankId, propertyNum, remarks);
	}
}
