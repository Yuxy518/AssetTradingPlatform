package com.atp.backend.mapper;

import com.atp.backend.pojo.MortgageInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: MortgageInfoMapper
 * @Author: Yuxy
 * @Description: mortgage_info数据表对应mapper类
 * @DateTime: 2023/2/21 17:59
 **/

@Mapper
public interface MortgageInfoMapper extends BaseMapper<MortgageInfo> {
}
