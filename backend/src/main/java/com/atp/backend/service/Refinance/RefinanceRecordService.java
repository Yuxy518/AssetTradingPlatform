package com.atp.backend.service.Refinance;

import java.util.Map;

/**
 * @ClassName: RefinanceRecordService
 * @Author: Yuxy
 * @Description: 转按揭记录接口
 * @DateTime: 2023/2/20 9:19
 **/

public interface RefinanceRecordService {
	public Map<String, String> refinanceRecord(Integer userId);
}
