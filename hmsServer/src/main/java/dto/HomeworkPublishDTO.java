package dto;

import java.util.Date;

public class HomeworkPublishDTO {

	private Long hId;

    private String hTitle;

    
    private String hPulishUrl;
    
    private Date endDate;

    private Long teacherId;
    
    private String classSpinner;
    
    private String courseSpinner;
    

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long gethId() {
		return hId;
	}

	public void sethId(Long hId) {
		this.hId = hId;
	}

	public String gethTitle() {
		return hTitle;
	}

	public void sethTitle(String hTitle) {
		this.hTitle = hTitle;
	}

	public String gethPulishUrl() {
		return hPulishUrl;
	}

	public void sethPulishUrl(String hPulishUrl) {
		this.hPulishUrl = hPulishUrl;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public String getClassSpinner() {
		return classSpinner;
	}

	public void setClassSpinner(String classSpinner) {
		this.classSpinner = classSpinner;
	}

	public String getCourseSpinner() {
		return courseSpinner;
	}

	public void setCourseSpinner(String courseSpinner) {
		this.courseSpinner = courseSpinner;
	}
    
    
}
