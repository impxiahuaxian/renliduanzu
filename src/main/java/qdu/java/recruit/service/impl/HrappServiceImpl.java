package qdu.java.recruit.service.impl;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import qdu.java.recruit.mapper.HrappMapper;
import qdu.java.recruit.service.HrappService;
@Service
public class HrappServiceImpl implements HrappService{
	@Resource
	HrappMapper hrappMapper;
	@Override
	public Boolean inserthrapp(int positionId, int hrId, int userId) {
		java.util.Date date = new java.util.Date();
        Timestamp recentTime = new Timestamp(date.getTime());
		int nwl = hrappMapper.inserthrapp(recentTime, positionId, hrId, userId);
		if(nwl>0) {
			return true;
		}
		return false;
	}
	@Override
	public int delecthrapp(int positionId, int userId) {
		// TODO Auto-generated method stub
		
		return hrappMapper.delecthrapp(positionId, userId);
	}

}
