package com.atp.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: ContractInfo
 * @Author: Yuxy
 * @Description: 数据表contract_info对应实体类
 * @DateTime: 2023/2/20 17:23
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "contract_info")
public class ContractInfo {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private Integer userId;
	private String sellerName;
	private String sellerIdNum;
	private String buyerName;
	private String buyerIdNum;
	private String propertyNum;
	private String submitTime;
	private String progress;
	private String remarks;
}
