package cn.teach.pojo.mall.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 课堂教学及评卷业绩点统计表
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@TableName("teach_course")
public class TeachCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 工号
     */
    private String jobNo;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 上课班级
     */
    private String className;


    /**
     * 类别(1,课堂;2,课程实践;3,实验课)
     */
    private String type;

    /**
     * 课程类型(1,理科专业理论课;2,文科专业理论课;3,通识教育必修理论课;4,通识教育必修大学英语课;5,理工类实验课;6,通识教育必修大学体育课;7,音乐技巧课;8,美术技巧课;9,体育技能课;10,通识教育选修课;11,外语专业课)

     */
    private String courseType;

    /**
     * 特殊课程(1,专科专业;2,双语课程;3,网络在线开放课;4,外语听力课;5,计算机上机课;6,无)
     */
    private String specialCourse;

    /**
     * 周学时数
     */
    private Integer weekHour;

    /**
     * 上课周数
     */
    private Integer weeks;

    /**
     * 原始总课时数
     */
    private Integer originalClassHour;

    /**
     * 选课学生人数
     */
    private Integer studentAmount;

    /**
     * 分班系数
     */
    private BigDecimal classCoefficient;

    /**
     * 课程系数
     */
    private BigDecimal courseCoefficient;

    /**
     * 教学结果系数(1,1.05;2,1;3,0)
     */
    private BigDecimal teachResultCoefficient;

    /**
     * 课堂教学业绩点

     */
    private BigDecimal courseTeachPoing;

    /**
     * 考核类型(1,考试;2,考查;3,无)
     */
    private String inspectType;

    /**
     * 考核类型系数(1,2.5;2,1;3,0)

     */
    private BigDecimal inspectTypeCoefficient;

    /**
     * 评卷业绩点
     */
    private BigDecimal markExamPoint;

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 状态(0 待提交 ,1 待审核,2审核通过,3审核驳回)
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 提交时间
     */
    private Date commitTime;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 审核人id
     */
    private Integer managerId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getSpecialCourse() {
        return specialCourse;
    }

    public void setSpecialCourse(String specialCourse) {
        this.specialCourse = specialCourse;
    }

    public Integer getWeekHour() {
        return weekHour;
    }

    public void setWeekHour(Integer weekHour) {
        this.weekHour = weekHour;
    }

    public Integer getWeeks() {
        return weeks;
    }

    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }

    public Integer getOriginalClassHour() {
        return originalClassHour;
    }

    public void setOriginalClassHour(Integer originalClassHour) {
        this.originalClassHour = originalClassHour;
    }

    public Integer getStudentAmount() {
        return studentAmount;
    }

    public void setStudentAmount(Integer studentAmount) {
        this.studentAmount = studentAmount;
    }

    public BigDecimal getClassCoefficient() {
        return classCoefficient;
    }

    public void setClassCoefficient(BigDecimal classCoefficient) {
        this.classCoefficient = classCoefficient;
    }

    public BigDecimal getCourseCoefficient() {
        return courseCoefficient;
    }

    public void setCourseCoefficient(BigDecimal courseCoefficient) {
        this.courseCoefficient = courseCoefficient;
    }

    public BigDecimal getTeachResultCoefficient() {
        return teachResultCoefficient;
    }

    public void setTeachResultCoefficient(BigDecimal teachResultCoefficient) {
        this.teachResultCoefficient = teachResultCoefficient;
    }

    public BigDecimal getCourseTeachPoing() {
        return courseTeachPoing;
    }

    public void setCourseTeachPoing(BigDecimal courseTeachPoing) {
        this.courseTeachPoing = courseTeachPoing;
    }

    public String getInspectType() {
        return inspectType;
    }

    public void setInspectType(String inspectType) {
        this.inspectType = inspectType;
    }

    public BigDecimal getInspectTypeCoefficient() {
        return inspectTypeCoefficient;
    }

    public void setInspectTypeCoefficient(BigDecimal inspectTypeCoefficient) {
        this.inspectTypeCoefficient = inspectTypeCoefficient;
    }

    public BigDecimal getMarkExamPoint() {
        return markExamPoint;
    }

    public void setMarkExamPoint(BigDecimal markExamPoint) {
        this.markExamPoint = markExamPoint;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "TeachCourse{" +
                "id=" + id +
                ", jobNo='" + jobNo + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", className='" + className + '\'' +
                ", type='" + type + '\'' +
                ", courseType='" + courseType + '\'' +
                ", specialCourse='" + specialCourse + '\'' +
                ", weekHour=" + weekHour +
                ", weeks=" + weeks +
                ", originalClassHour=" + originalClassHour +
                ", studentAmount=" + studentAmount +
                ", classCoefficient=" + classCoefficient +
                ", courseCoefficient=" + courseCoefficient +
                ", teachResultCoefficient=" + teachResultCoefficient +
                ", courseTeachPoing=" + courseTeachPoing +
                ", inspectType='" + inspectType + '\'' +
                ", inspectTypeCoefficient=" + inspectTypeCoefficient +
                ", markExamPoint=" + markExamPoint +
                ", teacherId=" + teacherId +
                ", status=" + status +
                ", createTime=" + createTime +
                ", commitTime=" + commitTime +
                ", auditTime=" + auditTime +
                ", managerId=" + managerId +
                '}';
    }
}
