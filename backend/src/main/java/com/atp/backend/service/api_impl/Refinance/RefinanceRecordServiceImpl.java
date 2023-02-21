package com.atp.backend.service.api_impl.Refinance;

import com.atp.backend.mapper.RefinanceContractMapper;
import com.atp.backend.mapper.RefinanceInfoMapper;
import com.atp.backend.pojo.Record;
import com.atp.backend.pojo.RefinanceContract;
import com.atp.backend.pojo.RefinanceInfo;
import com.atp.backend.service.api.Refinance.RefinanceRecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName: RefinanceRecordServiceImpl
 * @Author: Yuxy
 * @Description: 转按揭记录接口实现类
 * @DateTime: 2023/2/20 9:20
 **/

@Service
public class RefinanceRecordServiceImpl implements RefinanceRecordService {
	@Autowired
	RefinanceInfoMapper refinanceInfoMapper;
	@Autowired
	RefinanceContractMapper refinanceContractMapper;

	@Override
	public Map<String, String> refinanceRecord(Integer userId) {
		Map<String, String > map = new HashMap<>();
		List<Record> list = new ArrayList<>();

		QueryWrapper<RefinanceInfo> queryWrapper1 = new QueryWrapper<>();
		queryWrapper1.eq("userid", userId);
		List<RefinanceInfo> list1 = refinanceInfoMapper.selectList(queryWrapper1);

		for(RefinanceInfo refinanceInfo : list1) {
			list.add(new Record(refinanceInfo.getApplicationnum(), refinanceInfo.getSubmitdate(), null, "申请转按揭", refinanceInfo.getProgress(), refinanceInfo.getRemarks()));
		}

		QueryWrapper<RefinanceContract> queryWrapper2 = new QueryWrapper<>();
		queryWrapper2.eq("user_id", userId);
		List<RefinanceContract> list2 = refinanceContractMapper.selectList(queryWrapper2);

		for(RefinanceContract refinanceContract : list2) {
			list.add(new Record(refinanceContract.getApplyNum(), refinanceContract.getSubmitTime(), null, "提交转按揭合同", refinanceContract.getProgress(), refinanceContract.getRemarks()));
		}

		//按照提交时间递增排序
		list.sort(Comparator.comparing(Record::getSubmitTime));

		map.put("error_message", "success");
		JSONArray jsonArray = JSONArray.fromObject(list);
		String json_list  =  jsonArray.toString();
		map.put("list", json_list);
		return map;
	}
}
