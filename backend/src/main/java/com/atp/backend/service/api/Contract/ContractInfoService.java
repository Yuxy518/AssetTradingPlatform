package com.atp.backend.service.api.Contract;

import java.util.Map;

/**
 * @ClassName: ContractInfoService
 * @Author: Yuxy
 * @Description: 保存合同信息接口
 * @DateTime: 2023/2/20 17:28
 **/

public interface ContractInfoService {
	Map<String, String> contractInfo(Integer userId, String sellerName, String sellerIdNum, String buyerName, String buyerIdNum, String propertyNum, String remarks);
}
