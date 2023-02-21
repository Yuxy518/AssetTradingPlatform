package com.atp.backend.controller.Contract;

import com.atp.backend.service.api.Contract.ContractRecordService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: ContractRecordController
 * @Author: Yuxy
 * @Description: 获取合同记录接口，控制器层
 * @DateTime: 2023/2/21 15:27
 **/

@RestController
public class ContractRecordController {
	@Autowired
	ContractRecordService contractRecordService;

	@PostMapping("/contract/record/")
	public Map<String, String> contractRecord(@RequestParam Map<String, String> map){
		Integer userId = CommonUtils.parseInt(map.get("userId"));
		return contractRecordService.contractRecord(userId);
	}
}
