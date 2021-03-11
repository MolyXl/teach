package cn.teach.pojo.mall.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 外聘教师教学工作量统计表
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@TableName("foreign_teach")
public class ForeignTeach implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
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
     * 职称
     */
    private String position;

    /**
     * 学历
     */
    private String education;

    /**
     * 单位
     */
    private String unit;

    /**
     * 主要课程
     */
    private String course;

    /**
     * 主要班级
     */
    private String className;

    /**
     * 学生人数
     */
    private Integer studentAmount;

    /**
     * 周学时数
     */
    private Integer weekClassHour;

    /**
     * 上课周数
     */
    private Integer week;

    /**
     * 总课时数
     */
    private Integer classHour;

    /**
     * 单课时费用
     */
    private BigDecimal price;

    /**
     * 总费用
     */
    private BigDecimal totalPrice;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    /**
     * 提交时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date commitTime;

    /**
     * 审核时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getStudentAmount() {
        return studentAmount;
    }

    public void setStudentAmount(Integer studentAmount) {
        this.studentAmount = studentAmount;
    }

    public Integer getWeekClassHour() {
        return weekClassHour;
    }

    public void setWeekClassHour(Integer weekClassHour) {
        this.weekClassHour = weekClassHour;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getClassHour() {
        return classHour;
    }

    public void setClassHour(Integer classHour) {
        this.classHour = classHour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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

    @Override
    public String toString() {
        return "ForeignTeach{" +
        "id=" + id +
        ", jobNo=" + jobNo +
        ", teacherName=" + teacherName +
        ", position=" + position +
        ", education=" + education +
        ", unit=" + unit +
        ", course=" + course +
        ", className=" + className +
        ", studentAmount=" + studentAmount +
        ", weekClassHour=" + weekClassHour +
        ", week=" + week +
        ", classHour=" + classHour +
        ", price=" + price +
        ", totalPrice=" + totalPrice +
        ", teacherId=" + teacherId +
        ", status=" + status +
        ", createTime=" + createTime +
        ", commitTime=" + commitTime +
        ", auditTime=" + auditTime +
        ", managerId=" + managerId +
        "}";
    }
}
