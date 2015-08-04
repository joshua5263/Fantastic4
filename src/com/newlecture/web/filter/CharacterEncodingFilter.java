package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
		urlPatterns = {"/*"},
		initParams = {@WebInitParam(name = "encoding", value = "UTF-8")}
		)
public class CharacterEncodingFilter implements Filter {

	private String encoding;
	
	@Override
	public void destroy() {
		

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response); //사전, 사후 작업 분리
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
		encoding = config.getInitParameter("encoding");
		
	}

}
