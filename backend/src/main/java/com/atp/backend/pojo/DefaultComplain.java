package com.atp.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Complains
 * @Author: Yuxy
 * @Description: complains数据表对应实体类
 * @DateTime: 2023/2/22 9:56
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "default_complains")
public class DefaultComplain {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private Integer userId;
	private String userName;
	private String userIdNum;
	private String description;
	private String submitTime;
	private String progress;
}
