package com.atp.backend.service.api.Mortgage;

import java.util.Map;

/**
 * @ClassName: MortgageContractService
 * @Author: Yuxy
 * @Description: 保存合同信息接口
 * @DateTime: 2023/2/21 18:38
 **/

public interface MortgageContractService {
	public Map<String, String> mortgageContract(Integer userId, String serviceNum, String remarks);
}
