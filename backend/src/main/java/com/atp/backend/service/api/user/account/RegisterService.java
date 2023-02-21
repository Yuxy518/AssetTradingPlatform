package com.atp.backend.service.api.user.account;

import java.util.Map;

/**
 * @ClassName: RegisterService
 * @Author: Yuxy
 * @Description: api，注册接口
 * @DateTime: 2023/2/14 20:39
 **/

public interface RegisterService {
	public Map<String, String> register(String username, String password, String confirm_password);
}
