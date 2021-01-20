package qdu.java.recruit.renwu.service;

import org.springframework.beans.factory.annotation.Autowired;

import qdu.java.recruit.renwu.entity.User;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	private UserDaoService userdao;
	@Autowired
	private PaperDaoService paperdao;
	@Autowired
	private QuestionDaoService questiondao;
	@Autowired
	private AnswerDaoService answerdao;
	public int insertUser(User user) {
		return userdao.insertUser(user);
	}
	public boolean isesist(String username) {
		return userdao.isextist(username);
	}
	
}
