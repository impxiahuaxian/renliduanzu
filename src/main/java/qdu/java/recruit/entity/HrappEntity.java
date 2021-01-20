package qdu.java.recruit.entity;

import java.sql.Timestamp;

public class HrappEntity {
	private int Id;
	private int hrId;
	private int userId;
	private int positionId;
	private Timestamp recentTime;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getHrId() {
		return hrId;
	}
	public void setHrId(int hrId) {
		this.hrId = hrId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	public Timestamp getRecentTime() {
		return recentTime;
	}
	public void setRecentTime(Timestamp recentTime) {
		this.recentTime = recentTime;
	}
	
	
}
