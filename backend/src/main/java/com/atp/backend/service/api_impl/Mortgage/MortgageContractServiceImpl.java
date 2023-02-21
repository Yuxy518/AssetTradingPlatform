package com.atp.backend.service.api_impl.Mortgage;

import com.atp.backend.mapper.MortgageContractMapper;
import com.atp.backend.mapper.MortgageInfoMapper;
import com.atp.backend.pojo.MortgageContract;
import com.atp.backend.pojo.MortgageInfo;
import com.atp.backend.service.api.Mortgage.MortgageContractService;
import com.atp.backend.utils.CommonUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: MortgageContractServiceImpl
 * @Author: Yuxy
 * @Description: 保存合同信息接口，实现类
 * @DateTime: 2023/2/21 18:37
 **/

@Service
public class MortgageContractServiceImpl implements MortgageContractService {
	@Autowired
	MortgageInfoMapper mortgageInfoMapper;

	@Autowired
	MortgageContractMapper mortgageContractMapper;

	@Override
	public Map<String, String> mortgageContract(Integer userId, String serviceNum, String remarks) {
		Map<String, String> map = new HashMap<>();

		QueryWrapper<MortgageInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("service_num", serviceNum);

		List<MortgageInfo> list = mortgageInfoMapper.selectList(queryWrapper);
		if(list.size() == 0){
			map.put("error_message", "申请按揭贷款服务号错误，请先申请按揭贷款或者填写正确的服务号！");
			return map;
		}

		String submitTime = CommonUtils.getNowTime();
		String progress = "审核中";

		MortgageContract mortgageContract = new MortgageContract(null, userId, serviceNum, submitTime, progress, remarks);

		mortgageContractMapper.insert(mortgageContract);

		map.put("error_message", "success");
		return map;
	}
}
