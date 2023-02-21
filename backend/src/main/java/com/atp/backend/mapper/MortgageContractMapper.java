package com.atp.backend.mapper;

import com.atp.backend.pojo.MortgageContract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: MortgageContractMapper
 * @Author: Yuxy
 * @Description: mortgage_contract数据表mapper类
 * @DateTime: 2023/2/21 18:55
 **/

@Mapper
public interface MortgageContractMapper extends BaseMapper<MortgageContract> {
}
