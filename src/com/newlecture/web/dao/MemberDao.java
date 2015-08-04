package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.vo.Member;
import com.newlecture.web.vo.Notice;

public interface MemberDao {
	
	public Member getMember(String uid);
}
