package com.atp.backend.service.Deposit;

import java.util.Map;

/**
 * @ClassName: DepositInfoService
 * @Author: Yuxy
 * @Description: 保存支付信息接口
 * @DateTime: 2023/2/20 15:21
 **/

public interface DepositInfoService {
	public Map<String, String> depositInfo(Integer userId, String payerName, String payerIdNum, String propertyNum, Double mount, String remarks);
}
