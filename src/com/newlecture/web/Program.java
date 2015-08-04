package com.newlecture.web;

import java.util.List;

import javax.servlet.ServletException;





import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeDao;
import com.newlecture.web.dao.mybatis.SqlNewlecSessionFactory;
import com.newlecture.web.vo.Notice;

public class Program {
	
	static{
		SqlNewlecSessionFactory factory = new SqlNewlecSessionFactory();
		try {
			factory.init();
		} catch (ServletException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		
		/*NoticeDao noticeDao = new MybatisNoticeDao();
		
		NoticeConsole noticeConsole = new NoticeConsole();
		noticeConsole.setNoticeDao(noticeDao);*/

		ApplicationContext context = new ClassPathXmlApplicationContext("com/newlecture/web/spring-context.xml");
		
		NoticeConsole console = (NoticeConsole)context.getBean("noticeConsole");
		console.print();
		
	}

}
