package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Nana
 */
@WebServlet("/hi")
public class Nana extends HttpServlet {
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String _x = request.getParameter("x");
		String _y = request.getParameter("y");
		
		int x = 0;
		int y = 0;
		int result = 0;
		
		if(_x != null && _y != null && !_x.equals("") && !_y.equals(""))
		{
			x = Integer.parseInt(_x);
			y = Integer.parseInt(_y);
			
		}
		
		result = x + y;
		
		out.write("<form action=\"add\" method=\"post\">");

		out.write("<ul>");
		out.write("<li><label for=\"x\">X : </label><input name=\"x\"/></li>");
		out.write("<li><label for=\"y\">Y : </label><input name=\"y\"/></li>");
		out.write("</ul>");
			
		out.write("<p>");
		out.write("<input type=\"submit\" value=\"Calculate\"/>");		
		out.write("<input type=\"submit\" value=\"Application\"/>");
		out.write("<input type=\"submit\" value=\"Session\"/>");
		out.write("<input type=\"submit\" value=\"Cookie\"/>");
		
		out.write("</p>");

		out.write("</form>");
		
		
		out.printf("덧셈 결과는 : %d <br/>", result);
		
		out.println("<a href=\"MyPage\">마이페이지</a>");
		
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String _cnt = request.getParameter("cnt");
		
		int cnt = 10;
		
		if(_cnt != null && !_cnt.equals(""))
		{
			cnt = Integer.parseInt(_cnt);
		}
				
		for(int i = 0; i < cnt; i++){
			out.println("종하 tai <b>xihuan</b> ni <br/>");
		}
		out.close();
		
		
	}
	

}
