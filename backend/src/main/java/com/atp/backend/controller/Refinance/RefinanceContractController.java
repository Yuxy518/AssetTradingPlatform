package com.atp.backend.controller.Refinance;

import com.atp.backend.pojo.RefinanceContract;
import com.atp.backend.service.Refinance.RefinanceContractService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: RefinanceContractController
 * @Author: Yuxy
 * @Description: 保存合同接口控制器类
 * @DateTime: 2023/2/19 17:19
 **/

@RestController
public class RefinanceContractController {
	@Autowired
	RefinanceContractService refinanceContractService;

	@PostMapping("/refinance/contract/")
	public Map<String, String> refinanceContract(@RequestParam Map<String, String> map) {
		Integer userId = CommonUtils.parseInt(map.get("userId"));
		String applyNum = map.get("applyNum");
		String remarks = map.get("remarks");

		return refinanceContractService.refinanceContract(userId, applyNum, remarks);
	}
}
