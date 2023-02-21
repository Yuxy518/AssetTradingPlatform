package com.atp.backend.service.api_impl.Contract;

import com.atp.backend.mapper.ContractInfoMapper;
import com.atp.backend.pojo.ContractInfo;
import com.atp.backend.service.api.Contract.ContractInfoService;
import com.atp.backend.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ContractInfoServiceImpl
 * @Author: Yuxy
 * @Description: 保存合同信息接口实现类
 * @DateTime: 2023/2/20 17:32
 **/

@Service
public class ContractInfoServiceImpl implements ContractInfoService {
	@Autowired
	ContractInfoMapper contractInfoMapper;

	@Override
	public Map<String, String> contractInfo(Integer userId, String sellerName, String sellerIdNum, String buyerName, String buyerIdNum, String propertyNum, String remarks) {
		Map<String, String> map = new HashMap<>();

		sellerName = sellerName.trim();
		sellerIdNum = sellerIdNum.trim();
		buyerName = buyerName.trim();
		buyerIdNum = buyerIdNum.trim();
		propertyNum = propertyNum.trim();

		if(sellerName.length() == 0) {
			map.put("error_message", "请填写卖方姓名！");
			return  map;
		}
		else if(sellerIdNum.length() == 0) {
			map.put("error_message", "请填写卖方身份证号！");
			return map;
		}
		else if(buyerName.length() == 0) {
			map.put("error_message", "请填写买方姓名！");
			return map;
		}
		else if(buyerIdNum.length() == 0) {
			map.put("error_message", "请填写买方身份证号！");
			return map;
		}
		else if(propertyNum.length() == 0) {
			map.put("error_message", "请填写房产证明编号！");
			return map;
		}

		String nowTime = CommonUtils.getNowTime();
		String progress = "审核中";

		ContractInfo contractInfo = new ContractInfo(null, userId, sellerName, sellerIdNum, buyerName, buyerIdNum, propertyNum, nowTime, progress, remarks);

		contractInfoMapper.insert(contractInfo);

		map.put("error_message", "success");
		return map;
	}
}
