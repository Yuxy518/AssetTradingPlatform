package com.atp.backend.service.api_impl.Refinance;

import com.atp.backend.mapper.RefinanceContractMapper;
import com.atp.backend.mapper.RefinanceInfoMapper;
import com.atp.backend.pojo.RefinanceContract;
import com.atp.backend.pojo.RefinanceInfo;
import com.atp.backend.service.api.Refinance.RefinanceContractService;
import com.atp.backend.utils.CommonUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: RefinanceContractServiceImpl
 * @Author: Yuxy
 * @Description: 保存合同接口实现类
 * @DateTime: 2023/2/19 16:52
 **/

@Service
public class RefinanceContractServiceImpl implements RefinanceContractService {
	@Autowired
	RefinanceInfoMapper refinanceInfoMapper;

	@Autowired
	RefinanceContractMapper refinanceContractMapper;

	@Override
	public Map<String, String> refinanceContract(Integer userId, String applyNum, String remarks) {
		Map<String, String> map = new HashMap<>();

		applyNum = applyNum.trim();
		if(applyNum.length() == 0) {
			map.put("error_message", "请输入申请转按揭处理编号！");
			return map;
		}

		QueryWrapper<RefinanceInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("applicationnum", applyNum);
		List<RefinanceInfo> contractList = refinanceInfoMapper.selectList(queryWrapper);

		if(contractList.size() == 0) {
			map.put("error_message", "转按揭申请处理编号错误！");
			return map;
		}

		String progress = "审核中";
		String nowTime = CommonUtils.getNowTime();

		RefinanceContract refinanceContract = new RefinanceContract(null, userId, applyNum, nowTime, progress, remarks);
		refinanceContractMapper.insert(refinanceContract);

		map.put("error_message", "success");
		return map;
	}
}
