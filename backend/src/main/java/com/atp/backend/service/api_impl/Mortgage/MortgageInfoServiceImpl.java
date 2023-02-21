package com.atp.backend.service.api_impl.Mortgage;

import com.atp.backend.mapper.MortgageInfoMapper;
import com.atp.backend.pojo.MortgageInfo;
import com.atp.backend.service.api.Mortgage.MortgageInfoService;
import com.atp.backend.utils.CommonUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: MortgageInfoServiceImpl
 * @Author: Yuxy
 * @Description: 按揭贷款信息实现类
 * @DateTime: 2023/2/21 17:52
 **/

@Service
public class MortgageInfoServiceImpl implements MortgageInfoService {
	@Autowired
	MortgageInfoMapper mortgageInfoMapper;

	@Override
	public Map<String, String> mortgageInfo(Integer userId, String name, String idNum, String bankName, String bankId, String propertyNum, String remarks) {
		Map<String, String> map = new HashMap<>();

		name = name.trim();
		idNum = idNum.trim();
		bankName = bankName.trim();
		bankId = bankId.trim();
		propertyNum = propertyNum.trim();

		if(name.length() == 0) {
			map.put("error_message", "请填写贷款人姓名！");
			return map;
		}
		else if(idNum.length() == 0) {
			map.put("error_message", "请填写贷款人身份证号！");
			return map;
		}
		else if(bankName.length() == 0) {
			map.put("error_message", "请填写银行名称！");
			return map;
		}
		else if(bankId.length() == 0) {
			map.put("error_message", "请填写银行银联号！");
			return map;
		}
		else if(propertyNum.length() == 0) {
			map.put("error_message", "请填写房产证明编号");
			return map;
		}

		String submitTime = CommonUtils.getNowTime();
		String progress = "审核中";
		String serviceNum = CommonUtils.getRandomNum(5);

		QueryWrapper<MortgageInfo> queryWrapper = new QueryWrapper<>();

		for(int i = 0; i < 100; i ++) {
			queryWrapper.eq("service_num", serviceNum);
			List<MortgageInfo> list = mortgageInfoMapper.selectList(queryWrapper);
			if(list.size() != 0) serviceNum = CommonUtils.getRandomNum(5);
			else break;
		}

		MortgageInfo mortgageInfo = new MortgageInfo(null, userId, name, idNum, bankName, bankId, submitTime, progress, remarks, serviceNum);

		mortgageInfoMapper.insert(mortgageInfo);

		map.put("error_message", "success");
		return map;
	}
}
