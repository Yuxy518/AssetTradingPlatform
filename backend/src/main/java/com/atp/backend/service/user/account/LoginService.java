package com.atp.backend.service.user.account;

import java.util.Map;

/**
 * @ClassName: LoginService
 * @Author: Yuxy
 * @Description: api接口，通过账号密码获取jwt
 * @DateTime: 2023/2/14 20:37
 **/

public interface LoginService {
	public Map<String, String> getJwt(String username, String password);
}
