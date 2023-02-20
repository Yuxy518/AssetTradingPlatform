package com.atp.backend.mapper;

import com.atp.backend.pojo.ContractInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: ContractInfoMapper
 * @Author: Yuxy
 * @Description: 数据表contarct_info对应mapper类
 * @DateTime: 2023/2/20 17:27
 **/

@Mapper
public interface ContractInfoMapper extends BaseMapper<ContractInfo> {
}
