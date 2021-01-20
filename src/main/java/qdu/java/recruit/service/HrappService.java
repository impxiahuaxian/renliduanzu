package qdu.java.recruit.service;

import org.apache.ibatis.annotations.Param;

public interface HrappService {
	Boolean inserthrapp(int positionId, int hrId,int userId);
	
	int delecthrapp(int positionId,int userId);

}
