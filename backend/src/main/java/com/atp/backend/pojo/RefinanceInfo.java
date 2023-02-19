package com.atp.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: RefinanceInfo
 * @Author: Yuxy
 * @Description: 转按揭申请信息
 * @DateTime: 2023/2/19 9:34
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "refinanceinfo") //对应数据表的表名
public class RefinanceInfo {
	@TableId(type = IdType.AUTO) //自增变量
	private Integer id;
	private Integer userid;
	private String applicationnum;
	private String oriname;
	private String oriidnum;
	private String newname;
	private String newidnum;
	private String realpropertynum;
	private String fundnum;
	private String submitdate;
	private String progress;
	private String remarks;
}
