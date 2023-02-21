package com.atp.backend.service.api.Mortgage;

import java.util.Map;

/**
 * @ClassName: MorteageInfoService
 * @Author: Yuxy
 * @Description: 按揭贷款信息接口
 * @DateTime: 2023/2/21 17:41
 **/

public interface MortgageInfoService {
	Map<String, String> mortgageInfo(Integer userId, String name, String idNum, String bankNum, String bankId, String propertyNum, String remarks);
}
