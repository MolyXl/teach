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
 * 教师教学工作量汇总表
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@TableName("teach_teaching")
public class TeachTeaching implements Serializable {

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
     * 上半年课堂教学业绩点
     */
    private BigDecimal firstTeachPoint;

    /**
     * 上半年监考业绩点
     */
    private BigDecimal firstInspectPoint;

    /**
     * 上半年实践教学业绩点
     */
    private BigDecimal firstOtherPoint;

    /**
     * 上半年合计业绩点
     */
    private BigDecimal firstTotalPoint;

    /**
     * 下半年课堂教学业绩点
     */
    private BigDecimal secondTeachPoint;

    /**
     * 下半年监考业绩点
     */
    private BigDecimal secondInspectPoint;

    /**
     * 下半年实践教学业绩点
     */
    private BigDecimal secondOtherPoint;

    /**
     * 下半年合计业绩点
     */
    private BigDecimal secondTotalPoint;

    /**
     * 全年合计业绩点
     */
    private BigDecimal totalPoint;

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 状态(0,待提交;1,待审核;2,审核通过;3,审核驳回)
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

    public BigDecimal getFirstTeachPoint() {
        return firstTeachPoint;
    }

    public void setFirstTeachPoint(BigDecimal firstTeachPoint) {
        this.firstTeachPoint = firstTeachPoint;
    }

    public BigDecimal getFirstInspectPoint() {
        return firstInspectPoint;
    }

    public void setFirstInspectPoint(BigDecimal firstInspectPoint) {
        this.firstInspectPoint = firstInspectPoint;
    }

    public BigDecimal getFirstOtherPoint() {
        return firstOtherPoint;
    }

    public void setFirstOtherPoint(BigDecimal firstOtherPoint) {
        this.firstOtherPoint = firstOtherPoint;
    }

    public BigDecimal getFirstTotalPoint() {
        return firstTotalPoint;
    }

    public void setFirstTotalPoint(BigDecimal firstTotalPoint) {
        this.firstTotalPoint = firstTotalPoint;
    }

    public BigDecimal getSecondTeachPoint() {
        return secondTeachPoint;
    }

    public void setSecondTeachPoint(BigDecimal secondTeachPoint) {
        this.secondTeachPoint = secondTeachPoint;
    }

    public BigDecimal getSecondInspectPoint() {
        return secondInspectPoint;
    }

    public void setSecondInspectPoint(BigDecimal secondInspectPoint) {
        this.secondInspectPoint = secondInspectPoint;
    }

    public BigDecimal getSecondOtherPoint() {
        return secondOtherPoint;
    }

    public void setSecondOtherPoint(BigDecimal secondOtherPoint) {
        this.secondOtherPoint = secondOtherPoint;
    }

    public BigDecimal getSecondTotalPoint() {
        return secondTotalPoint;
    }

    public void setSecondTotalPoint(BigDecimal secondTotalPoint) {
        this.secondTotalPoint = secondTotalPoint;
    }

    public BigDecimal getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(BigDecimal totalPoint) {
        this.totalPoint = totalPoint;
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
        return "TeachTeaching{" +
                "id=" + id +
                ", jobNo=" + jobNo +
                ", teacherName=" + teacherName +
                ", firstTeachPoint=" + firstTeachPoint +
                ", firstInspectPoint=" + firstInspectPoint +
                ", firstOtherPoint=" + firstOtherPoint +
                ", firstTotalPoint=" + firstTotalPoint +
                ", secondTeachPoint=" + secondTeachPoint +
                ", secondInspectPoint=" + secondInspectPoint +
                ", secondOtherPoint=" + secondOtherPoint +
                ", secondTotalPoint=" + secondTotalPoint +
                ", teacherId=" + teacherId +
                ", status=" + status +
                ", createTime=" + createTime +
                ", commitTime=" + commitTime +
                ", auditTime=" + auditTime +
                ", managerId=" + managerId +
                "}";
    }
}
