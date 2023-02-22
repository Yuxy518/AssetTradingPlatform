package com.atp.backend.mapper;

import com.atp.backend.pojo.DefaultComplain;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: ComplainsMapper
 * @Author: Yuxy
 * @Description: complains数据表对应Mapper类
 * @DateTime: 2023/2/22 9:58
 **/

@Mapper
public interface DefaultComplainMapper extends BaseMapper<DefaultComplain> {
}
