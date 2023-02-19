package com.atp.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: RefinanceContract
 * @Author: Yuxy
 * @Description: 数据表实体类
 * @DateTime: 2023/2/19 16:46
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "refinancecontract")
public class RefinanceContract {
	//	解决驼峰和下划线之间的自动映射：
	// 	数据表字段名和实体类属性名，两者一个用驼峰命名一个用下划线命名；
	// 	或者添加注解指定数据库字段名@TableField("userId")
	@TableId(type = IdType.AUTO)
	private Integer id;
	private Integer userId;
	private String applyNum;
	private String submitTime;
	private String progress;
	private String remarks;
}
