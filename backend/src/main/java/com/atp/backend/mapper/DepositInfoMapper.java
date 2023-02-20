package com.atp.backend.mapper;

import com.atp.backend.pojo.DepositInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: DepositInfoMapper
 * @Author: Yuxy
 * @Description: 数据表deposit_info的Mapper类
 * @DateTime: 2023/2/20 15:31
 **/

@Mapper
public interface DepositInfoMapper extends BaseMapper<DepositInfo> {
}
