package com.atp.backend.service.api.Deposit;

import java.util.Map;

/**
 * @ClassName: DepositRecordService
 * @Author: Yuxy
 * @Description: 获取支付定金记录接口
 * @DateTime: 2023/2/20 16:12
 **/

public interface DepositRecordService {
	Map<String, String> depositRecord(Integer userId);
}
