package dao;

import java.util.Date;

public class HomeworkSubmit {
    private Long hSubmitId;

    private Long studentId;

    private String hSubmitUrl;

    private String remark;

    private Date createDate;

    private Long hId;

    private Long attachId;

    private String rateLevel;

    public Long gethSubmitId() {
        return hSubmitId;
    }

    public void sethSubmitId(Long hSubmitId) {
        this.hSubmitId = hSubmitId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String gethSubmitUrl() {
        return hSubmitUrl;
    }

    public void sethSubmitUrl(String hSubmitUrl) {
        this.hSubmitUrl = hSubmitUrl == null ? null : hSubmitUrl.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long gethId() {
        return hId;
    }

    public void sethId(Long hId) {
        this.hId = hId;
    }

    public Long getAttachId() {
        return attachId;
    }

    public void setAttachId(Long attachId) {
        this.attachId = attachId;
    }

    public String getRateLevel() {
        return rateLevel;
    }

    public void setRateLevel(String rateLevel) {
        this.rateLevel = rateLevel == null ? null : rateLevel.trim();
    }
}