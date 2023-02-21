package com.atp.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: MortgageContract
 * @Author: Yuxy
 * @Description: mortgage_contract数据表，按揭合同实体类
 * @DateTime: 2023/2/21 18:53
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "mortgage_contract")
public class MortgageContract {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private Integer userId;
	private String serviceNum;
	private String submitTime;
	private String progress;
	private String remarks;
}
