package com.atp.backend.config;

/**
 * @ClassName: CorsConfig
 * @Author: Yuxy
 * @Description: 用来解决跨域问题
 * @DateTime: 2023/2/14 17:33
 **/

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CorsConfig implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

		String origin = request.getHeader("Origin");
		if(origin!=null) {
			response.setHeader("Access-Control-Allow-Origin", origin);
		}

		String headers = request.getHeader("Access-Control-Request-Headers");
		if(headers!=null) {
			response.setHeader("Access-Control-Allow-Headers", headers);
			response.setHeader("Access-Control-Expose-Headers", headers);
		}

		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Credentials", "true");

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) {

	}

	@Override
	public void destroy() {
	}
}