package com.atp.backend.controller.Refinance;

import com.atp.backend.service.Refinance.RefinanceInfoService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: RefinanceInfoController
 * @Author: Yuxy
 * @Description: 保存转按揭申请信息api
 * @DateTime: 2023/2/19 10:14
 **/

@RestController
public class RefinanceInfoController {
	@Autowired
	RefinanceInfoService refinanceInfoService;

	@PostMapping("/refinance/info/")
	public Map<String, String> refinanceInfo(@RequestParam Map<String, String> mp){
		Integer userId = CommonUtils.parseInt(mp.get("userId"));
		String oriName = mp.get("oriName");
		String oriIdNum = mp.get("oriIdNum");
		String newName = mp.get("newName");
		String newIdNum = mp.get("newIdNum");
		String fundNum = mp.get("fundNum");
		String realPropertyNum = mp.get("realPropertyNum");
		String remarks = mp.get("remarks");

		return refinanceInfoService.refinanceInfo(userId, oriName, oriIdNum, newName, newIdNum, fundNum, realPropertyNum, remarks);
	}
}
