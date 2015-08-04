package com.newlecture.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeDao;
import com.newlecture.web.vo.Notice;


public class SpringNoticeController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		NoticeDao noticeDao = new MybatisNoticeDao();
		List<Notice> list = noticeDao.getNotices();		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/view/customer/notice.jsp");
		mv.addObject("list", list);
		
		/*
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/notice.jsp");
		dispatcher.forward(request, response);*/
		
		return mv;
	}

}
