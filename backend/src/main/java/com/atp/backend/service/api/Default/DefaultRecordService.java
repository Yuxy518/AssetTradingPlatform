package com.atp.backend.service.api.Default;

import java.util.Map;

/**
 * @ClassName: DefaultRecordService
 * @Author: Yuxy
 * @Description: 获取投诉记录接口
 * @DateTime: 2023/2/22 10:20
 **/

public interface DefaultRecordService {
	public Map<String, String> defaultRecord(Integer userId);
}
