package com.atp.backend.service.api.Refinance;

import java.util.Map;

/**
 * @ClassName: RefinanceContractService
 * @Author: Yuxy
 * @Description: 保存合同接口
 * @DateTime: 2023/2/19 16:49
 **/

public interface RefinanceContractService {
	public Map<String, String> refinanceContract(Integer userId, String applyNum, String remarks);
}
