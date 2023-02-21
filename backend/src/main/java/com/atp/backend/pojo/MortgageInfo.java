package com.atp.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: MortgageInfo
 * @Author: Yuxy
 * @Description: mortgage_info数据表实体类
 * @DateTime: 2023/2/21 17:56
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "mortgage_info")
public class MortgageInfo {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private Integer userId;
	private String name;
	private String idNum;
	private String bankName;
	private String bankId;
	private String submitTime;
	private String progress;
	private String remarks;
	private String serviceNum;
}
