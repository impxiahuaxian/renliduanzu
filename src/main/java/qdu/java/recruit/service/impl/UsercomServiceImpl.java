package qdu.java.recruit.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import qdu.java.recruit.entity.UsercomEntity;
import qdu.java.recruit.mapper.CommentMapper;
import qdu.java.recruit.mapper.UsercomMapper;
import qdu.java.recruit.pojo.HrCommentBO;
import qdu.java.recruit.pojo.UserCommentBO;
import qdu.java.recruit.service.UsercomService;
@Service
@Primary
public class UsercomServiceImpl implements UsercomService{

	@Resource
	private UsercomMapper usercomMapper;
	@Override
	public ArrayList<UsercomEntity> listUser() {
		// TODO Auto-generated method stub
		ArrayList<UsercomEntity> UsercomEntity1 = usercomMapper.listUser();
		return UsercomEntity1;
	}

	@Override
	public int saveUsercom(int fenshu, int userId, int hrId, int positionId,String usercontent) {
		java.util.Date date = new java.util.Date();
        Timestamp userreleaseTime = new Timestamp(date.getTime());
        int nwl = usercomMapper.saveUsercom(fenshu, userId, hrId,positionId, userreleaseTime, usercontent);
		return nwl;
	}

	@Override
	public PageInfo<HrCommentBO> listhrcomment(int userId,int page,int limit) {
		 PageHelper.startPage(page,limit);
	        List<HrCommentBO> commentList = usercomMapper.listhrcomment(userId);
	        PageInfo<HrCommentBO> comList = new PageInfo<>(commentList);
	        return comList;
	}

}
