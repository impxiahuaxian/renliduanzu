package qdu.java.recruit.service.impl;

import org.springframework.stereotype.Service;

import qdu.java.recruit.entity.UserEntity;
import qdu.java.recruit.mapper.ApplicationMapper;
import qdu.java.recruit.pojo.ApplicationPositionHRBO;
import qdu.java.recruit.pojo.UserWorkBO;
import qdu.java.recruit.service.ApplicationService;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Resource
    private ApplicationMapper applicationMapper;

    @Override
    public boolean applyPosition(int resumeId, int positionId) {

        //获取当前日期时间
        java.util.Date date = new java.util.Date();
        Timestamp recentTime = new Timestamp(date.getTime());

        int result = applicationMapper.saveApplication(recentTime, resumeId, positionId);
        if (result > 0) {
            return true;
        }
        return false;
    }

    /**
     * 申请处理完成
     * @param resumeId
     * @return
     */
    @Override
    public List<ApplicationPositionHRBO> listApplyInfo(int resumeId){

        return applicationMapper.listAppPosHR(resumeId);
    }

    /**
     * 申请待处理
     * @param resumeId
     * @return
     */
    @Override
    public List<ApplicationPositionHRBO> listApplyInfoPub(int resumeId){

        return applicationMapper.listAppPosHRPub(resumeId);
    }
  
    @Override
    public List<ApplicationPositionHRBO> listWorkInfoPub(int resumeId){

        return applicationMapper.listWorkInfoPub(resumeId);
    }
    @Override
    public List<ApplicationPositionHRBO> listApplyInfoByHr(int hrid) {
        return applicationMapper.listAppPosHR(hrid);

    }
    @Override
    public List<UserEntity> listApplyInfoByHr1(int hrid) {
        return applicationMapper.listAppPosHR1(hrid);

    }
    @Override
    public List<UserWorkBO> listApplyInfoByHr2(int hrid) {
        return applicationMapper.listAppPosHR2(hrid);

    }
    @Override
    public List<UserWorkBO> listApplyInfoByHrtitle(int hrid) {
        return applicationMapper.listApplyInfoByHrtitle(hrid);

    }
    public int stateApplication(int resumeId,int workid) {
        return applicationMapper.stateApplication(resumeId,workid);

    }
    @Override
    public  boolean refusePosition(int state, int hrId,int resumeId,int workid) {
    	int result = applicationMapper.updateApplication(state,hrId,resumeId,workid);
        if (result > 0) {
            return true;
        }
        return false;
    }
    
}
