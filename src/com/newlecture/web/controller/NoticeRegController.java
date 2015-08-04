package com.newlecture.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.omg.CORBA.Request;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeFileDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

/*@WebServlet("/customer/NoticeReg")*/
@MultipartConfig(
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*5,
		maxRequestSize = 1024*1024*5*5 
		)
public class NoticeRegController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getMethod().equals("POST"))
		{
			Part part = request.getPart("file");
			ServletContext application = request.getServletContext();
			
			String url = "/customer/upload";
			String path = application.getRealPath(url);
			String temp = part.getSubmittedFileName();
			String fname = temp.substring(temp.lastIndexOf('\\') + 1);
			String fpath = path + "\\" + fname;
			/*response.getWriter().println(fpath);*/
			
			InputStream ins = part.getInputStream();
			OutputStream outs = new FileOutputStream(fpath);
			
			byte[] aa = new byte[1024];
			int len = 0;
			
			while((len = ins.read(aa, 0, 1024)) >= 0)
				outs.write(aa, 0, len);
			
			outs.flush();
			outs.close();
			ins.close();
			
			String title = request.getParameter("title");
			String file = request.getParameter("file");
			String content = request.getParameter("content");
			
			Notice notice = new Notice();
			NoticeFile noticeFile = new NoticeFile();
			
			notice.setTitle(title);		
			notice.setWriter("jongha");
			notice.setContent(content);
			
			NoticeDao noticeDao = new MybatisNoticeDao();
			noticeDao.addNotice(notice);
			
			NoticeFileDao noticeFileDao = new MybatisNoticeFileDao();
			noticeFile.setName(fname);
			noticeFile.setNoticeCode(noticeDao.getLastCode());
			noticeFileDao.addNoticeFile(noticeFile);
			
			response.sendRedirect("Notice");
		}
		else{
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/noticeReg.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
