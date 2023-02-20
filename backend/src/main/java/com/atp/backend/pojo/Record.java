package com.atp.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Record
 * @Author: Yuxy
 * @Description: 记录类
 * @DateTime: 2023/2/20 9:26
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
	private String submitTime;
	private String module;
	private String type;
	private String progress;
	private String remarks;
}
