package com.atp.backend.service.impl.Deposit;

import com.atp.backend.mapper.DepositInfoMapper;
import com.atp.backend.pojo.DepositInfo;
import com.atp.backend.pojo.Record;
import com.atp.backend.service.Deposit.DepositRecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DepositRecordServiceImpl
 * @Author: Yuxy
 * @Description: 获取支付定金记录接口实现类
 * @DateTime: 2023/2/20 16:14
 **/

@Service
public class DepositRecordServiceImpl implements DepositRecordService {
	@Autowired
	DepositInfoMapper depositInfoMapper;

	@Override
	public Map<String, String> depositRecord(Integer userId) {
		Map<String, String> map = new HashMap<>();

		QueryWrapper<DepositInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_id", userId);

		List<DepositInfo> list = depositInfoMapper.selectList(queryWrapper);

		map.put("error_message", "success");

		list.sort(Comparator.comparing(DepositInfo::getSubmitTime));

		JSONArray jsonArray = JSONArray.fromObject(list);
		String json_list = jsonArray.toString();

		map.put("list", json_list);

		return map;
	}
}
