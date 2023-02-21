package com.atp.backend.service.api.Refinance;

import java.util.Map;

/**
 * @ClassName: RefinanceInfoService
 * @Author: Yuxy
 * @Description: 转按揭信息存储
 * @DateTime: 2023/2/19 9:40
 **/

public interface RefinanceInfoService {
	public Map<String, String> refinanceInfo(Integer userId, String oriName, String oriIdNum, String newName, String newIdNum, String fundNum, String realPropertyNum, String remarks);
}
