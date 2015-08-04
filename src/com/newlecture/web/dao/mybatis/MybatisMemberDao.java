package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.vo.Member;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.dao.mybatis.SqlNewlecSessionFactory;
import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.vo.Notice;

public class MybatisMemberDao implements MemberDao{

	//SqlSessionFactory factory = new SqlNewlecSessionFactory().getSqlSessionFactory();

	private SqlSession session;
	
	@Autowired	
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public Member getMember(String uid) {
		
		//SqlSession session = factory.openSession();
		
		MemberDao dao = session.getMapper(MemberDao.class);		
		
		return dao.getMember(uid);
	}
}
