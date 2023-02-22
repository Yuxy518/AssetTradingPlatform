package com.atp.backend.service.api.Default;

import java.util.Map;

/**
 * @ClassName: ComplainService
 * @Author: Yuxy
 * @Description: 保存投诉信息接口
 * @DateTime: 2023/2/22 9:59
 **/

public interface DefaultComplainService {
	public Map<String, String> defaultComplain(Integer userId, String userName, String userIdNum, String description);
}
