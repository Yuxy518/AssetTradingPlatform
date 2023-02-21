package com.atp.backend.service.api_impl.user.account;

import com.atp.backend.pojo.User;
import com.atp.backend.service.api.user.account.LoginService;
import com.atp.backend.utils.JwtUtil;
import com.atp.backend.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LoginServiceImpl
 * @Author: Yuxy
 * @Description: 接口实现类：用户登录，获取jwt
 * @DateTime: 2023/2/14 20:41
 **/

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public Map<String, String> getJwt(String username, String password) {

		//将用户名密码封装成一个字符串
		UsernamePasswordAuthenticationToken authenticationToken =
			new UsernamePasswordAuthenticationToken(username, password);

		Authentication authenticate = authenticationManager.authenticate(authenticationToken);	//如果用户名密码不对，自动处理

		//取出用户
		UserDetailsImpl loginUser = (UserDetailsImpl)authenticate.getPrincipal();
		User user = loginUser.getUser();

		//通过id生成jwt
		String jwt = JwtUtil.createJWT(user.getId().toString());

		//返回json
		Map<String, String> map = new HashMap<>();
		map.put("error_message", "success");
		map.put("jwt_token", jwt);

		return map;
	}
}
