package com.atp.backend.service.impl.user.account;

import com.atp.backend.pojo.User;
import com.atp.backend.service.user.account.InfoService;
import com.atp.backend.utils.UserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: InfoServiceImpl
 * @Author: Yuxy
 * @Description: 接口实现类，通过jwt获取用户信息
 * @DateTime: 2023/2/14 21:14
 **/

@Service
public class InfoServiceImpl implements InfoService {

	@Override
	public Map<String, String> getInfo() {
		//将用户信息从上下文中提取出来
		UsernamePasswordAuthenticationToken authentication =
				(UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

		UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
		User user = loginUser.getUser();

		Map<String, String> map = new HashMap<>();
		map.put("error_message", "success");
		map.put("userid", user.getId().toString());
		map.put("username", user.getUsername());
		map.put("photo", user.getPhoto());
		map.put("is_admin", user.getIsadmin().toString());

		return map;
	}
}
