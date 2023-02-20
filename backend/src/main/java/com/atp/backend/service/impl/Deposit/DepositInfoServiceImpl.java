package com.atp.backend.service.impl.Deposit;

import com.atp.backend.mapper.DepositInfoMapper;
import com.atp.backend.pojo.DepositInfo;
import com.atp.backend.service.Deposit.DepositInfoService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DepositInfoServiceImpl
 * @Author: Yuxy
 * @Description: 保存支付信息接口实现类
 * @DateTime: 2023/2/20 15:24
 **/

@Service
public class DepositInfoServiceImpl implements DepositInfoService {
	@Autowired
	DepositInfoMapper depositInfoMapper;

	@Override
	public Map<String, String> depositInfo(Integer userId, String payerName, String payerIdNum, String propertyNum, Double mount, String remarks) {
		Map<String, String> map = new HashMap<>();

		payerName = payerIdNum.trim();
		payerIdNum = payerIdNum.trim();
		propertyNum = propertyNum.trim();

		if(payerName.length() == 0) {
			map.put("error_message", "请填写支付人姓名！");
			return map;
		}
		else if(payerIdNum.length() == 0) {
			map.put("error_message", "请填写支付人身份证号");
			return map;
		}
		else if(propertyNum.length() == 0) {
			map.put("error_message", "请填写不动产权证明编号");
			return map;
		}

		String nowTime = CommonUtils.getNowTime();
		String progress = "审核中";

		DepositInfo depositInfo = new DepositInfo(null, userId, payerName, payerIdNum, propertyNum, mount, nowTime, progress, remarks);

		depositInfoMapper.insert(depositInfo);

		map.put("error_message", "success");
		return map;
	}
}
