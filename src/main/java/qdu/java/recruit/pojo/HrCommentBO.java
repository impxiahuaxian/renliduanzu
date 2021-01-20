package qdu.java.recruit.pojo;

import java.sql.Timestamp;

public class HrCommentBO {

	private String hrName;
	private String usercontent; 
	private int fenshu;
	private int Id;
	private Timestamp userreleaseTime;
	public String getHrName() {
		return hrName;
	}
	public void setHrName(String hrName) {
		this.hrName = hrName;
	}
	public String getUsercontent() {
		return usercontent;
	}
	public void setUsercontent(String usercontent) {
		this.usercontent = usercontent;
	}
	public int getFenshu() {
		return fenshu;
	}
	public void setFenshu(int fenshu) {
		this.fenshu = fenshu;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Timestamp getUserreleaseTime() {
		return userreleaseTime;
	}
	public void setUserreleaseTime(Timestamp userreleaseTime) {
		this.userreleaseTime = userreleaseTime;
	}
}
