package com.newlecture.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.vo.Member;

public class NewlecAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {		
		//로그인 한 유저 아이디 가져오기
		String uid = authentication.getName();
		
		//유저의 DefaultRole을 가져오기 위해 Member vo와 Dao import
		Member m = memberDao.getMember(uid);
		
		//유저의 DefaultRole을 type이라는 변수에 담기
		String type = m.getDefaultRole();
		
		//일반 유저일 경우 로그인 성공 시 이동할 타겟 페이지
		String targetUrl = "/customer/notice";
		
		//역할에 따라 로그인 성공 시 이동할 타겟 페이지 조건문으로 설정
		if(type.equals("ROLE_TEACHER")){
			targetUrl = "/customer/noticeDetail?c=5";
		}
		
		//RedirectStrategy를 통해 페이지 이동시키기
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
}
