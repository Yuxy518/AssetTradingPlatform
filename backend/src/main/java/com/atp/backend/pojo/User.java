package com.atp.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: User
 * @Author: Yuxy
 * @Description: 用户类
 * @DateTime: 2023/2/14 17:30
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@TableId(type = IdType.AUTO) //自增
	private Integer id;
	private String username;
	private String password;
	private String photo;
	private Integer isadmin;
}
