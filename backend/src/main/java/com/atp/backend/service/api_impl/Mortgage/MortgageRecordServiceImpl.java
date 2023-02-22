package com.atp.backend.service.api_impl.Mortgage;

import com.atp.backend.mapper.MortgageContractMapper;
import com.atp.backend.mapper.MortgageInfoMapper;
import com.atp.backend.pojo.MortgageContract;
import com.atp.backend.pojo.MortgageInfo;
import com.atp.backend.pojo.Record;
import com.atp.backend.service.api.Mortgage.MortgageRecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName: MortgageRecordServiceImpl
 * @Author: Yuxy
 * @Description: 获取按揭贷款记录接口实现类
 * @DateTime: 2023/2/21 19:10
 **/

@Service
public class MortgageRecordServiceImpl implements MortgageRecordService {
	@Autowired
	MortgageInfoMapper mortgageInfoMapper;

	@Autowired
	MortgageContractMapper mortgageContractMapper;

	@Override
	public Map<String, String> mortgageRecord(Integer userId) {
		Map<String, String> map = new HashMap<>();
		List<Record> list = new ArrayList<>();

		QueryWrapper<MortgageInfo> queryWrapper1 = new QueryWrapper<>();
		queryWrapper1.eq("user_id", userId);
		List<MortgageInfo> list1 = mortgageInfoMapper.selectList(queryWrapper1);

		for(MortgageInfo mortgageInfo : list1) {
			list.add(new Record(mortgageInfo.getServiceNum(), mortgageInfo.getName(), mortgageInfo.getIdNum(), null, null, mortgageInfo.getSubmitTime(), "办理按揭贷款", "申请贷款", mortgageInfo.getProgress(), mortgageInfo.getRemarks()));
		}

		QueryWrapper<MortgageContract> queryWrapper2 = new QueryWrapper<>();
		queryWrapper2.eq("user_id", userId);
		List<MortgageContract> list2 = mortgageContractMapper.selectList(queryWrapper2);

		for(MortgageContract mortgageContract : list2) {
			QueryWrapper<MortgageInfo> queryWrapper = new QueryWrapper<>();
			queryWrapper.eq("service_num", mortgageContract.getServiceNum());
			MortgageInfo mortgageInfo = mortgageInfoMapper.selectOne(queryWrapper);
			list.add(new Record(mortgageContract.getServiceNum(), mortgageInfo.getName(), mortgageInfo.getIdNum(), null, null, mortgageContract.getSubmitTime(), "办理按揭贷款", "提交按揭贷款合同", mortgageContract.getProgress(), mortgageContract.getRemarks()));
		}

		list.sort(Comparator.comparing(Record::getSubmitTime));

		JSONArray jsonArray = JSONArray.fromObject(list);
		String list_json = jsonArray.toString();

		map.put("list", list_json);
		map.put("error_message", "success");
		return map;
	}
}
