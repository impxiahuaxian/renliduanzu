package qdu.java.recruit.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import qdu.java.recruit.entity.HREntity;

import java.util.ArrayList;

/**
 * <P>
 *     private int hrId;
 private String hrMobile;
 private String hrPassword;
 private String hrName;
 private String hrEmail;
 private String description;
 private int departmentId;
 * </P>
 */
@Mapper
public interface HRMapper {
    /**
     * <p>`hrId` int(11) NOT NULL AUTO_INCREMENT,
     `hrMobile` varchar(11) NOT NULL,
     `hrPassword` varchar(500) NOT NULL,
     `hrName` varchar(50) DEFAULT NULL,
     `hrEmail` varchar(50) DEFAULT NULL,
     `description` longtext,
     `departmentId` int(11) NOT NULL,</p>
     *
     */

    @Select("select * from hr")
    ArrayList<HREntity> listHR();

    @Select("select * from hr where hrId = #{hrId}")
    HREntity getHR(@Param("hrId") int hrId);

    @Select("select COUNT(*) from hr")
    int getHRSize();

    @Update({"update hr set hrPassword = #{hrPassword},hrName=#{hrName},hrEmail=#{hrEmail}," +
            "description=#{description},departmentId=#{departmentId},hrSex=#{hrSex},hrAddress=#{hrAddress} where hrId = #{hrId}"})
    int updateHR(HREntity hrEntity);

    @Insert({"insert into hr(hrMobile,hrPassword,hrName,hrEmail,description,departmentId,hrSex,hrAddress) " +
            "values(#{hrMobile},#{hrPassword},#{hrName},#{hrEmail},#{description},#{departmentId},#{hrSex},#{hrAddress})"})
    int saveHR(HREntity hrEntity);

    @Select("select * from hr where hrMobile = #{mobile} limit 1")
    HREntity getHRByMobile(@Param("mobile") String moblie);

    
}
