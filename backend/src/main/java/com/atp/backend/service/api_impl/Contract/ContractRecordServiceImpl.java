package com.atp.backend.service.api_impl.Contract;

import com.atp.backend.mapper.ContractInfoMapper;
import com.atp.backend.pojo.ContractInfo;
import com.atp.backend.service.api.Contract.ContractRecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ContractRecordServiceImpl
 * @Author: Yuxy
 * @Description: 获取合同记录，接口实现类
 * @DateTime: 2023/2/21 14:53
 **/

@Service
public class ContractRecordServiceImpl implements ContractRecordService {
	@Autowired
	ContractInfoMapper contractInfoMapper;

	@Override
	public Map<String, String> contractRecord(Integer userId) {
		Map<String, String> map = new HashMap<>();

		QueryWrapper<ContractInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_id", userId);

		List<ContractInfo> list = contractInfoMapper.selectList(queryWrapper);
		list.sort(Comparator.comparing(ContractInfo::getSubmitTime));

		JSONArray jsonArray = JSONArray.fromObject(list);
		String list_json = jsonArray.toString();

		map.put("list", list_json);
		map.put("error_message", "success");

		return map;
	}
}
