package com.newlecture.web;

import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.vo.Notice;

public class HiNoticeDao implements NoticeDao {

	@Override
	public List<Notice> getNotices(int page, String field, String query) {
		// TODO �ڵ� ������ �޼ҵ� ����
		return null;
	}

	@Override
	public List<Notice> getNotices(int page) {
		// TODO �ڵ� ������ �޼ҵ� ����
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
		// TODO �ڵ� ������ �޼ҵ� ����
		return null;
	}

	@Override
	public int addNotice(Notice notice) {
		// TODO �ڵ� ������ �޼ҵ� ����
		return 0;
	}

	@Override
	public String getLastCode() {
		// TODO �ڵ� ������ �޼ҵ� ����
		return null;
	}

}
