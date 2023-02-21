package com.atp.backend.service.api.Mortgage;

import java.util.Map;

/**
 * @ClassName: MortgageRecordService
 * @Author: Yuxy
 * @Description: 获取按揭贷款记录接口
 * @DateTime: 2023/2/21 19:10
 **/

public interface MortgageRecordService {
	public Map<String, String> mortgageRecord(Integer userId);
}
