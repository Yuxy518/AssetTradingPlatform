package com.atp.backend.service.api_impl.Default;

import com.atp.backend.mapper.DefaultComplainMapper;
import com.atp.backend.pojo.DefaultComplain;
import com.atp.backend.service.api.Default.DefaultComplainService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DefaultComplainServiceImpl
 * @Author: Yuxy
 * @Description: 保存投诉信息接口，实现类
 * @DateTime: 2023/2/22 10:04
 **/

@Service
public class DefaultComplainServiceImpl implements DefaultComplainService {
	@Autowired
	DefaultComplainMapper defaultComplainMapper;

	@Override
	public Map<String, String> defaultComplain(Integer userId, String userName, String userIdNum, String description) {
		Map<String, String> map = new HashMap<>();

		userIdNum = userIdNum.trim();
		if(userIdNum.length() == 0) {
			map.put("error_message", "请输入身份证号！");
			return map;
		}
		else if(userIdNum.length() != 18) {
			map.put("error_message", "请输入18位身份证号！");
			return map;
		}
		description = description.trim();
		if(description.length() == 0) {
			map.put("error_message", "请描述您所遇到的问题！");
			return map;
		}

		String submitTime = CommonUtils.getNowTime();
		String progress = "审核中";

		DefaultComplain defaultComplains = new DefaultComplain(null, userId, userName, userIdNum, description, submitTime, progress);

		defaultComplainMapper.insert(defaultComplains);
		map.put("error_message", "success");

		return map;
	}
}
