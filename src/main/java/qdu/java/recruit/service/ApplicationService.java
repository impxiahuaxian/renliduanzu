package qdu.java.recruit.service;


import qdu.java.recruit.entity.UserEntity;
import qdu.java.recruit.pojo.ApplicationPositionHRBO;
import qdu.java.recruit.pojo.UserWorkBO;

import java.util.List;

public interface ApplicationService {

    boolean applyPosition(int resumeId, int positionId);

    List<ApplicationPositionHRBO> listApplyInfo(int resumeId);

    List<ApplicationPositionHRBO> listApplyInfoPub(int resumeId);

    List<ApplicationPositionHRBO> listApplyInfoByHr(int hrid);
    
    List<UserEntity> listApplyInfoByHr1(int hrid1);
    
    List<UserWorkBO> listApplyInfoByHr2(int hrid2);
    
    List<UserWorkBO> listApplyInfoByHrtitle(int hrid3);
    
    int stateApplication(int resumeId,int workid);
    
    boolean refusePosition(int state, int hrId,int resumeId,int workid);

    List<ApplicationPositionHRBO> listWorkInfoPub(int resumeId);

}
