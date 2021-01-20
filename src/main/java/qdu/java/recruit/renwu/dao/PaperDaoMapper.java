package qdu.java.recruit.renwu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import qdu.java.recruit.renwu.entity.Paper;
@Mapper
public interface PaperDaoMapper {
		//插入问卷 返回id
		public int addPaper(Paper paper)throws Exception;
		//查询单个问卷
		public Paper queryOnePaper(int pid)throws Exception;
		//查询用户问卷列表
		public List<Paper> getUserList(@Param("uid") int uid,@Param("begin") int begin,@Param("end") int end) throws Exception;
		//显示答题人数
		public int getAnswerCount(int pid)throws Exception; 
		//删除问卷
		public void deletePaper(int pid)throws Exception;
		
		//查询问卷的id
		public int idPaper(@Param("hrid") int hrid,@Param("resumeId") int resumeId)throws Exception;
}
