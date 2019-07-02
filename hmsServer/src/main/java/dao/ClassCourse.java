package dao;

public class ClassCourse {
    private Integer tachId;

    private String courseId;

    private Long classId;

    public Integer getTachId() {
        return tachId;
    }

    public void setTachId(Integer tachId) {
        this.tachId = tachId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}