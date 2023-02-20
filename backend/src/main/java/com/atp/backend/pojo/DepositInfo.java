package com.atp.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: DepositInfo
 * @Author: Yuxy
 * @Description: 数据表deposit_info对应实体类
 * @DateTime: 2023/2/20 14:56
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "deposit_info")
public class DepositInfo{
	@TableId(type = IdType.AUTO)
	private Integer id;
	private Integer userId;
	private String payerName;
	private String payerIdNum;
	private String propertyNum;
	private Double mount;
	private String submitTime;
	private String progress;
	private String remarks;
}
