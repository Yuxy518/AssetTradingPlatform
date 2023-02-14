package com.atp.backend.mapper;

import com.atp.backend.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: UserMapper
 * @Author: Yuxy
 * @Description:
 * @DateTime: 2023/2/14 17:55
 **/

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
