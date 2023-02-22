package com.atp.backend.service.api_impl.user;

import com.atp.backend.mapper.*;
import com.atp.backend.pojo.*;
import com.atp.backend.service.api.user.AllRecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName: AllRecordServiceImpl
 * @Author: Yuxy
 * @Description: 获取所有记录接口，实现类
 * @DateTime: 2023/2/22 12:05
 **/

@Service
public class AllRecordServiceImpl implements AllRecordService {
	@Autowired
	RefinanceInfoMapper refinanceInfoMapper;
	@Autowired
	RefinanceContractMapper refinanceContractMapper;
	@Autowired
	DepositInfoMapper depositInfoMapper;
	@Autowired
	ContractInfoMapper contractInfoMapper;
	@Autowired
	MortgageInfoMapper mortgageInfoMapper;
	@Autowired
	MortgageContractMapper mortgageContractMapper;
	@Autowired
	DefaultComplainMapper defaultComplainMapper;

	@Override
	public Map<String, String> allRecordService(Integer userId) {
		Map<String, String> map = new HashMap<>();
		List<Record> list = new ArrayList<>();

		QueryWrapper<RefinanceInfo> refinanceInfoQueryWrapper = new QueryWrapper<>();
		refinanceInfoQueryWrapper.eq("userid", userId);
		List<RefinanceInfo> refinanceInfos = refinanceInfoMapper.selectList(refinanceInfoQueryWrapper);

		for(RefinanceInfo refinanceInfo : refinanceInfos) {
			list.add(new Record(null, refinanceInfo.getOriname(), refinanceInfo.getOriidnum(), refinanceInfo.getNewname(), refinanceInfo.getNewidnum(), refinanceInfo.getSubmitdate(), "办理转按揭", "申请转按揭", refinanceInfo.getProgress(), refinanceInfo.getRemarks()));
		}

		QueryWrapper<RefinanceContract> refinanceContractQueryWrapper = new QueryWrapper<>();
		refinanceContractQueryWrapper.eq("user_id", userId);
		List<RefinanceContract> refinanceContracts = refinanceContractMapper.selectList(refinanceContractQueryWrapper);

		for(RefinanceContract refinanceContract : refinanceContracts) {
			QueryWrapper<RefinanceInfo> refinanceInfoQueryWrapper1 = new QueryWrapper<>();
			refinanceInfoQueryWrapper1.eq("applicationnum", refinanceContract.getApplyNum());
			RefinanceInfo refinanceInfo = refinanceInfoMapper.selectOne(refinanceInfoQueryWrapper1);
			list.add(new Record(null, refinanceInfo.getOriname(), refinanceInfo.getOriidnum(), refinanceInfo.getNewname(), refinanceInfo.getNewidnum(), refinanceContract.getSubmitTime(), "办理转按揭", "提交转按揭合同", refinanceContract.getProgress(), refinanceContract.getRemarks()));
		}

		QueryWrapper<DepositInfo> depositInfoQueryWrapper = new QueryWrapper<>();
		depositInfoQueryWrapper.eq("user_id", userId);
		List<DepositInfo> depositInfos = depositInfoMapper.selectList(depositInfoQueryWrapper);
		for(DepositInfo depositInfo : depositInfos) {
			list.add(new Record(null, depositInfo.getPayerName(), depositInfo.getPayerIdNum(), null, null, depositInfo.getSubmitTime(), "交定金", "提交定金信息", depositInfo.getProgress(), depositInfo.getRemarks()));
		}

		QueryWrapper<ContractInfo> contractInfoQueryWrapper = new QueryWrapper<>();
		contractInfoQueryWrapper.eq("user_id", userId);
		List<ContractInfo> contractInfos = contractInfoMapper.selectList(contractInfoQueryWrapper);
		for(ContractInfo contractInfo : contractInfos) {
			list.add(new Record(null, contractInfo.getSellerName(), contractInfo.getSellerIdNum(), contractInfo.getBuyerName(), contractInfo.getBuyerIdNum(), contractInfo.getSubmitTime(), "购房交易合同", "提交购房交易合同信息", contractInfo.getProgress(), contractInfo.getRemarks()));
		}

		QueryWrapper<MortgageInfo> mortgageInfoQueryWrapper = new QueryWrapper<>();
		mortgageInfoQueryWrapper.eq("user_id", userId);
		List<MortgageInfo> mortgageInfos = mortgageInfoMapper.selectList(mortgageInfoQueryWrapper);
		for(MortgageInfo mortgageInfo : mortgageInfos) {
			list.add(new Record(null, mortgageInfo.getName(), mortgageInfo.getIdNum(), null, null, mortgageInfo.getSubmitTime(), "办理按揭贷款", "申请按揭贷款", mortgageInfo.getProgress(), mortgageInfo.getRemarks()));
		}

		QueryWrapper<MortgageContract> mortgageContractQueryWrapper = new QueryWrapper<>();
		mortgageContractQueryWrapper.eq("user_id", userId);
		List<MortgageContract> mortgageContracts = mortgageContractMapper.selectList(mortgageContractQueryWrapper);
		for(MortgageContract mortgageContract : mortgageContracts) {
			QueryWrapper<MortgageInfo> mortgageInfoQueryWrapper1 = new QueryWrapper<>();
			mortgageInfoQueryWrapper1.eq("service_num", mortgageContract.getServiceNum());
			MortgageInfo mortgageInfo = mortgageInfoMapper.selectOne(mortgageInfoQueryWrapper1);
			list.add(new Record(null, mortgageInfo.getName(), mortgageInfo.getIdNum(), null, null, mortgageContract.getSubmitTime(), "办理按揭贷款", "提交按揭贷款合同", mortgageContract.getProgress(), mortgageContract.getRemarks()));
		}

		QueryWrapper<DefaultComplain> defaultComplainQueryWrapper = new QueryWrapper<>();
		defaultComplainQueryWrapper.eq("user_id", userId);
		List<DefaultComplain> defaultComplains = defaultComplainMapper.selectList(defaultComplainQueryWrapper);
		for(DefaultComplain defaultComplain : defaultComplains) {
			list.add(new Record(null, defaultComplain.getUserName(), defaultComplain.getUserIdNum(), null, null, defaultComplain.getSubmitTime(), "违约处理", "投诉违约", defaultComplain.getProgress(), null));
		}

		list.sort(Comparator.comparing(Record::getSubmitTime));
		JSONArray jsonArray = JSONArray.fromObject(list);
		String list_json = jsonArray.toString();

		map.put("list", list_json);
		map.put("error_message", "success");

		return map;
	}
}
