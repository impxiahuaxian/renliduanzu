package qdu.java.recruit.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import qdu.java.recruit.entity.ApplicationEntity;
import qdu.java.recruit.entity.UserEntity;
import qdu.java.recruit.pojo.ApplicationPositionHRBO;
import qdu.java.recruit.pojo.UserWorkBO;

import java.sql.Timestamp;
import java.util.ArrayList;
@Mapper
public interface ApplicationMapper {

    @Select("select * from application where resumeId = #{resumeId}")
    ArrayList<ApplicationEntity> listApplication(@Param("resumeId") int resumeId);

    @Select("select * from application where resumeId = #{resumeId} and positionId = #{posId} limit 1")
    ApplicationEntity getApplication(@Param("resumeId") int resumeId, @Param("posId") int posId);

    @Insert("insert into application(state,recentTime,resumeId,positionId) values (0,#{recentTime},#{resumeId},#{positionId})")
    int saveApplication(@Param("recentTime") Timestamp recentTime, @Param("resumeId") int resumeId, @Param("positionId") int positionId);

    /**
     * 申请处理完成：查询返回 申请 职位 处理hr信息
     * @param resumeId
     * @return
     */
    @Select("select a.applicationId,a.state,a.recentTime,a.resumeId,p.*,h.hrId,h.hrMobile,h.hrName,h.hrEmail\n" +
            "from application a,position p,hr h\n" +
            "where a.positionId = p.positionId and a.hrId = h.hrId \n" +
            "and a.hrId is not null and a.resumeId = #{resumeId}\n" +
            "order by recentTime;")
    ArrayList<ApplicationPositionHRBO> listAppPosHR(@Param("resumeId") int resumeId);
    @Select("select * from user where userId  IN (select resumeId from application where positionId IN ( Select positionId from position where hrIdPub = #{resumeId}))")
    ArrayList<UserEntity> listAppPosHR1(@Param("resumeId") int resumeId);
//    @Select("select * from user where userId  IN (select resumeId from application where positionId IN ( Select positionId from position where hrIdPub = #{resumeId}) and state = 1)")
    @Select("select a.mobile,a.name,a.city,a.graduation,a.userId,b.title,b.positionId,b.hrIdPub,c.hrId from user a , position b,application c where a.userId = c.resumeId and b.positionId = c.positionId \r\n" + 
    		"and  b.positionId IN ( Select positionId from position where hrIdPub = #{resumeId}) and c.state = 1")
    ArrayList<UserWorkBO> listAppPosHR2(@Param("resumeId") int resumeId);
    /**
     * 申请待处理：查询返回 申请 职位 发布hr信息
     * @param resumeId
     * @return
     */
    @Select("select a.applicationId,a.state,a.recentTime,a.resumeId,p.*,h.hrId,h.hrMobile,h.hrName,h.hrEmail\n" +
            "from application a,position p,hr h\n" +
            "where a.positionId = p.positionId and p.hrIdPub = h.hrId \n" +
            "and a.hrId is null and a.resumeId = #{resumeId}\n" +
            "order by p.releaseDate;")
    ArrayList<ApplicationPositionHRBO> listAppPosHRPub(@Param("resumeId") int resumeId);
    @Select("select a.applicationId,a.state,a.recentTime,a.resumeId,p.*,h.hrId,h.hrMobile,h.hrName,h.hrEmail from application a,position p,hr h \r\n" + 
    		"where a.positionId = p.positionId and p.hrIdPub = h.hrId  and a.resumeId = #{resumeId} and a.state = 1 order by p.releaseDate;")
    ArrayList<ApplicationPositionHRBO> listWorkInfoPub(@Param("resumeId") int resumeId);
    
//    @Update("UPDATE application SET state = #{state},hrId = #{hrId} WHERE resumeId = #{resumeId} and positionId IN (Select positionId from position where hrIdPub = #{hrId})")
    @Update("UPDATE application SET state = #{state},hrId = #{hrId} WHERE resumeId = #{resumeId} and positionId = #{workid}")
    int updateApplication(@Param("state") int state,@Param("hrId") int hrId,@Param("resumeId") int resumeId,@Param("workid") int workid);
    @Select("select a.mobile,a.name,a.city,a.graduation,a.userId,b.title,b.positionId,b.hrIdPub,c.hrId from user a , position b,application c where a.userId = c.resumeId and b.positionId = c.positionId and  b.positionId IN ( Select positionId from position where hrIdPub = #{resumeId} and c.state = 0)")
    ArrayList<UserWorkBO> listApplyInfoByHrtitle(@Param("resumeId") int resumeId);
    @Select("select state from application where resumeId = #{resumeId} and positionId = #{workid}")
    int stateApplication(@Param("resumeId") int resumeId,@Param("workid") int workid);
}
