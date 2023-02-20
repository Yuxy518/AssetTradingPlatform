package com.atp.backend.service.impl.Refinance;

import com.atp.backend.mapper.RefinanceInfoMapper;
import com.atp.backend.pojo.RefinanceInfo;
import com.atp.backend.service.Refinance.RefinanceInfoService;
import com.atp.backend.utils.CommonUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: RefinanceInfoService
 * @Author: Yuxy
 * @Description: 转按揭信息保存api实现类
 * @DateTime: 2023/2/19 9:45
 **/

@Service
public class RefinanceInfoServiceImpl implements RefinanceInfoService {
	@Autowired
	RefinanceInfoMapper refinanceInfoMapper;

	@Override
	public Map<String, String> refinanceInfo(Integer userId, String oriName, String oriIdNum, String newName, String newIdNum, String fundNum, String realPropertyNum, String remarks)
	{
		Map<String, String> map = new HashMap<>();
		oriName = oriName.trim();
		oriIdNum = oriIdNum.trim();
		newName = newName.trim();
		newIdNum =  newIdNum.trim();
		fundNum = fundNum.trim();
		realPropertyNum = realPropertyNum.trim();


		if(oriName.length() == 0){
			map.put("error_message", "原借款人姓名不能为空！");
			return map;
		}
		else if(oriIdNum.length() == 0) {
			map.put("error_message", "原借款人身份证号不能为空！");
			return map;
		}
		else if(oriIdNum.length() != 18) {
			map.put("error_message", "原借款人身份证号格式错误！");
			return map;
		}
		else if(newName.length() == 0) {
			map.put("error_message", "新借款人姓名不能为空！");
			return map;
		}
		else if(newIdNum.length() == 0) {
			map.put("error_message", "新借款人身份证号不能为空！");
			return map;
		}
		else if(newIdNum.length() != 18) {
			map.put("error_message", "新借款人身份证号格式错误！");
			return map;
		}
		else if(realPropertyNum.length() == 0) {
			map.put("error_message", "不动产权证明编号不能为空！");
			return map;
		}

		String randomNum = CommonUtils.getRandomNum(5);

		QueryWrapper<RefinanceInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("applicationnum", randomNum);

		for(int i = 0; i < 100; i ++){
			List<RefinanceInfo> refinanceInfoList = refinanceInfoMapper.selectList(queryWrapper);
			if(refinanceInfoList.size() != 0) randomNum = CommonUtils.getRandomNum(5);
			else break;
		}

		String nowTime = CommonUtils.getNowTime();
		String progress = "审核中";

		RefinanceInfo refinanceInfo = new RefinanceInfo(null, userId, randomNum, oriName, oriIdNum, newName, newIdNum, realPropertyNum, fundNum, nowTime, progress, remarks);

		refinanceInfoMapper.insert(refinanceInfo);

		map.put("error_message", "success");
		return map;
	}


}
