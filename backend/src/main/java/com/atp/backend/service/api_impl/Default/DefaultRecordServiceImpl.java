package com.atp.backend.service.api_impl.Default;

import com.atp.backend.mapper.DefaultComplainMapper;
import com.atp.backend.pojo.DefaultComplain;
import com.atp.backend.service.api.Default.DefaultRecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DefaultRecordServiceImpl
 * @Author: Yuxy
 * @Description: 获取投诉记录接口，实现类
 * @DateTime: 2023/2/22 10:22
 **/

@Service
public class DefaultRecordServiceImpl implements DefaultRecordService {
	@Autowired
	DefaultComplainMapper defaultComplainMapper;

	@Override
	public Map<String, String> defaultRecord(Integer userId) {
		Map<String, String> map = new HashMap<>();

		QueryWrapper<DefaultComplain> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_id", userId);
		List<DefaultComplain> list = defaultComplainMapper.selectList(queryWrapper);

		list.sort(Comparator.comparing(DefaultComplain::getSubmitTime));

		JSONArray jsonArray = JSONArray.fromObject(list);
		String list_json = jsonArray.toString();

		map.put("list", list_json);
		map.put("error_message", "success");

		return map;
	}
}
