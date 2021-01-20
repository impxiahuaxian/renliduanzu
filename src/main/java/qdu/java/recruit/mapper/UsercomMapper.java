package qdu.java.recruit.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import qdu.java.recruit.entity.UsercomEntity;
import qdu.java.recruit.pojo.HrCommentBO;

@Mapper
public interface UsercomMapper {
	 @Select("select * from usercomment")
	 ArrayList<UsercomEntity> listUser();
	 @Insert("insert into usercomment(fenshu,userId,hrId,positionId,userreleaseTime,usercontent) values (#{fenshu},#{userId},#{hrId},#{positionId},#{userreleaseTime},#{usercontent})")
	 int saveUsercom(@Param("fenshu") int fenshu, @Param("userId") int userId, @Param("hrId") int hrId, @Param("positionId") int positionId, @Param("userreleaseTime") Timestamp userreleaseTime, @Param("usercontent") String usercontent);
	 @Select("select usercomment.usercontent,usercomment.fenshu,usercomment.Id,usercomment.userreleaseTime,hr.hrName from usercomment,hr \r\n" + 
	 		"where usercomment.hrId = hr.hrId and userId = #{userId} order by userreleaseTime DESC")
	 ArrayList<HrCommentBO> listhrcomment(@Param("userId") int userId);
}
