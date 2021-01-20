package qdu.java.recruit.mapper;

import java.sql.Timestamp;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HrappMapper {
	@Insert("insert into hrapplication (recentTime,positionId,hrId,userId) values (#{recentTime},#{positionId},#{hrId},#{userId})")
	int inserthrapp(@Param("recentTime") Timestamp recentTime, @Param("positionId") int positionId, @Param("hrId") int hrId, @Param("userId") int userId);
	@Delete("DELETE FROM hrapplication WHERE positionId = #{positionId} and userId = #{userId}")
	int delecthrapp(@Param("positionId") int positionId,@Param("userId") int userId);
}
