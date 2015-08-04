package com.newlecture.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeFileDao;
import com.newlecture.web.vo.Member;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

@Controller
@RequestMapping("/joinus/*")
public class JoinusController {
	
	private NoticeDao noticeDao;
	private NoticeFileDao noticeFileDao;
	
	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	@Autowired
	public void setNoticeFileDao(NoticeFileDao noticeFileDao) {
		this.noticeFileDao = noticeFileDao;
	}

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String noticeDetail(){
		
		
		return "joinus.login";
		//return "/WEB-INF/view/joinus/join.jsp";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String noticeDetail(Member m){
		
		
		return "joinus.login";
		//return "/WEB-INF/view/joinus/join.jsp";
	}
	
	

}
