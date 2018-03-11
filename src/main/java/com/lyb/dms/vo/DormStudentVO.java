package com.lyb.dms.vo;

public class DormStudentVO {
    private Integer dsId;

    private Integer studentId;
    
    private String studenName;

    private String studenNum;
    
    private Integer dormId;
    
    private String dormNum;
    
    private String capacity;

    private String joinTime;

    private String leaveTime;

    private String leaveReason;
    
    private Integer headId;

    private String createTime;

    private String remark;

	public Integer getDsId() {
		return dsId;
	}

	public void setDsId(Integer dsId) {
		this.dsId = dsId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudenName() {
		return studenName;
	}

	public void setStudenName(String studenName) {
		this.studenName = studenName;
	}

	public String getStudenNum() {
		return studenNum;
	}

	public void setStudenNum(String studenNum) {
		this.studenNum = studenNum;
	}

	public Integer getDormId() {
		return dormId;
	}

	public void setDormId(Integer dormId) {
		this.dormId = dormId;
	}

	public String getDormNum() {
		return dormNum;
	}

	public void setDormNum(String dormNum) {
		this.dormNum = dormNum;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}

	public String getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public Integer getHeadId() {
		return headId;
	}

	public void setHeadId(Integer headId) {
		this.headId = headId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "DormStudentVO [dsId=" + dsId + ", studentId=" + studentId + ", studenName=" + studenName
				+ ", studenNum=" + studenNum + ", dormId=" + dormId + ", dormNum=" + dormNum + ", capacity=" + capacity
				+ ", joinTime=" + joinTime + ", leaveTime=" + leaveTime + ", leaveReason=" + leaveReason + ", headId="
				+ headId + ", createTime=" + createTime + ", remark=" + remark + "]";
	}

	
    

  
    
}