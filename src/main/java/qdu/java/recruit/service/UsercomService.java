package qdu.java.recruit.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;

import qdu.java.recruit.entity.UsercomEntity;
import qdu.java.recruit.pojo.HrCommentBO;

public interface UsercomService {
 
	 ArrayList<UsercomEntity> listUser();
	 
	 int saveUsercom(int fenshu,int userId, int hrId,int positionId,String usercontent);
	 
	 PageInfo<HrCommentBO> listhrcomment(int userId,int page,int limit);
}
