package com.newlecture.web;

import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.vo.Notice;

public class HiNoticeDao implements NoticeDao {

	@Override
	public List<Notice> getNotices(int page, String field, String query) {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

	@Override
	public List<Notice> getNotices(int page) {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

	@Override
	public List<Notice> getNotices() {
		List<Notice> list = new ArrayList<Notice>();
		Notice n = new Notice();
		n.setTitle("bye");
		list.add(n);
		return list;
	}

	@Override
	public Notice getNotice(String code) {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

	@Override
	public int addNotice(Notice notice) {
		// TODO 자동 생성된 메소드 스텁
		return 0;
	}

	@Override
	public String getLastCode() {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

}
