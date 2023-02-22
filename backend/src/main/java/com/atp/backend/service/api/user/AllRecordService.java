package com.atp.backend.service.api.user;

import java.util.Map;

/**
 * @ClassName: AllRecordService
 * @Author: Yuxy
 * @Description: 获取所有记录接口
 * @DateTime: 2023/2/22 12:03
 **/

public interface AllRecordService {
	public Map<String, String> allRecordService(Integer userId);
}
