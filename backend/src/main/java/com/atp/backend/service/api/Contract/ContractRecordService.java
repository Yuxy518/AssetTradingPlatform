package com.atp.backend.service.api.Contract;

import java.util.Map;

/**
 * @ClassName: ContractRecordService
 * @Author: Yuxy
 * @Description: 获取合同记录接口
 * @DateTime: 2023/2/21 14:52
 **/

public interface ContractRecordService {
	public Map<String, String> contractRecord(Integer userId);
}
