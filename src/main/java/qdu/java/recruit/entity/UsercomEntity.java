package qdu.java.recruit.entity;

import java.sql.Timestamp;

public class UsercomEntity {
	private int Id;
    private int fenshu;
    private String usercontent;
    private Timestamp userreleaseTime;
    private int userId;
    private int hrId;
    private int positionId;
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getFenshu() {
		return fenshu;
	}
	public void setFenshu(int fenshu) {
		this.fenshu = fenshu;
	}
	public String getUsercontent() {
		return usercontent;
	}
	public void setUsercontent(String usercontent) {
		this.usercontent = usercontent;
	}
	public Timestamp getUserreleaseTime() {
		return userreleaseTime;
	}
	public void setUserreleaseTime(Timestamp userreleaseTime) {
		this.userreleaseTime = userreleaseTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHrId() {
		return hrId;
	}
	public void setHrId(int hrId) {
		this.hrId = hrId;
	}
    
}
