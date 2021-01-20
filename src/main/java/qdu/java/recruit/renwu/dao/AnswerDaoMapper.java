package qdu.java.recruit.renwu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import qdu.java.recruit.renwu.entity.Answer;
import qdu.java.recruit.renwu.entity.ChoiceAnswer;
import qdu.java.recruit.renwu.entity.QuestionAnswer;
import qdu.java.recruit.renwu.entity.Useranswer;
@Mapper
public interface AnswerDaoMapper {	
	//添加答案   制作人
	public void addAnswer(Answer answer)throws Exception;
	//删除答案
	public void deleteAnswer(int aid)throws Exception;
	//修改答案
	public void updateAnswer(Answer answer) throws Exception;
	//查询选择的答案
	public ChoiceAnswer choiceAnswer(int id) throws Exception;
	//查询简答的答案
	public QuestionAnswer questionAnswer(int id) throws Exception;
	//用户填写
	//插入答案  aid:问题id
	public void insertAnswer(Useranswer useranwer)throws Exception;
	
}
