package com.atp.backend.controller.Mortgage;

import com.atp.backend.service.api.Mortgage.MortgageContractService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: MortgageContractController
 * @Author: Yuxy
 * @Description: 保存按揭贷款合同接口，控制器层
 * @DateTime: 2023/2/21 18:58
 **/

@RestController
public class MortgageContractController {
	@Autowired
	MortgageContractService mortgageContractService;

	@PostMapping("/mortgage/contract/")
	public Map<String, String> mortgageContract(@RequestParam Map<String, String> map) {
		Integer userId = CommonUtils.parseInt(map.get("userId"));
		String serviceNum = map.get("serviceNum");
		String remarks = map.get("remarks");
		return mortgageContractService.mortgageContract(userId, serviceNum, remarks);
	}
}
