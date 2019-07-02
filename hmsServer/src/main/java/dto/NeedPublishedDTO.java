package dto;

import java.util.Date;

public class NeedPublishedDTO {
	
	private Long h_id;

	private String h_title;
	
	private String courseName;
	
	private String teacherName;
	
	private Date endDate;
	
	private String publishedUrl;
	
	private String submitUrl;
	
	private String rateLevel;
	
	private String remark;
	
	

	public String getRateLevel() {
		return rateLevel;
	}

	public void setRateLevel(String rateLevel) {
		this.rateLevel = rateLevel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSubmitUrl() {
		return submitUrl;
	}

	public void setSubmitUrl(String submitUrl) {
		this.submitUrl = submitUrl;
	}

	public Long getH_id() {
		return h_id;
	}

	public void setH_id(Long h_id) {
		this.h_id = h_id;
	}

	public String getH_title() {
		return h_title;
	}

	public void setH_title(String h_title) {
		this.h_title = h_title;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPublishedUrl() {
		return publishedUrl;
	}

	public void setPublishedUrl(String publishedUrl) {
		this.publishedUrl = publishedUrl;
	}
	
	
	
	
}
