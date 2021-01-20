package qdu.java.recruit.renwu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import qdu.java.recruit.renwu.dao.PaperDaoMapper;
import qdu.java.recruit.renwu.entity.Paper;

@Repository
public class PaperDaoService {
	@Resource
	private PaperDaoMapper dao;
	/*
	 * 插入问卷 返回id
	 */
	public int addPaper(Paper paper) {
		try {
			dao.addPaper(paper);
			return paper.getId();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("插入问卷失败");
			return -1;
		}
	}
	/*
	 * 查询单个问卷
	 */
	public Paper queryOnePaper(int pid) {
		try {
			return dao.queryOnePaper(pid);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("查询单个问卷失败");
			return null;
		}
	}
	/*
	 * 查询用户问卷列表
	 */
	public List<Paper> getUserList(int uid,int index) {
		try {
			int begin,end=10;
			begin=index*end-end;
			List<Paper> paper = dao.getUserList(uid,begin,end);
			
			return paper;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("查询用户问卷列表失败");
			return null;
		}
	}
	/*
	 * 查询答题人数
	 */
	public int getAnswerCount(int pid) {
		try {
			int count = dao.getAnswerCount(pid);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("查询答题人数失败");
			return -1;
		}
	}
	/*
	 * 删除问卷
	 */
	public boolean deletePaper(int pid) {
		try {
			dao.deletePaper(pid);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("删除问卷失败");
			return false;
		}
	}
	/*
	 * 查问问卷id
	 */
	public int idPaper(int hrid,int resumeId) {
		
		int n = 0;
		try {
			n = dao.idPaper(hrid,resumeId);
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("查找失败");
			return 0;
		}
	}
}
