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
 * 监考听课业绩点统计表
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@TableName("teach_exam")
public class TeachExam implements Serializable {

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
     * 上半年监考场次
     */
    private Integer examFirstExamAmount;

    /**
     * 上半年监考业绩点
     */
    private BigDecimal examFirstInspectPoint;

    /**
     * 下半年监考场次
     */
    private Integer examSecondExamAmount;

    /**
     * 下半年监考业绩点
     */
    private BigDecimal examSecondInspectPoint;

    /**
     * 上半年听课场次
     */
    private Integer listenFirstListenAmount;

    /**
     * 上半年听课业绩点
     */
    private BigDecimal listenFirstListenPoint;

    /**
     * 下半年听课场次
     */
    private Integer listenSecondListenAmount;

    /**
     * 下半年听课业绩点
     */
    private BigDecimal listenSecondListenPoint;

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

    public Integer getExamFirstExamAmount() {
        return examFirstExamAmount;
    }

    public void setExamFirstExamAmount(Integer examFirstExamAmount) {
        this.examFirstExamAmount = examFirstExamAmount;
    }

    public BigDecimal getExamFirstInspectPoint() {
        return examFirstInspectPoint;
    }

    public void setExamFirstInspectPoint(BigDecimal examFirstInspectPoint) {
        this.examFirstInspectPoint = examFirstInspectPoint;
    }

    public Integer getExamSecondExamAmount() {
        return examSecondExamAmount;
    }

    public void setExamSecondExamAmount(Integer examSecondExamAmount) {
        this.examSecondExamAmount = examSecondExamAmount;
    }

    public BigDecimal getExamSecondInspectPoint() {
        return examSecondInspectPoint;
    }

    public void setExamSecondInspectPoint(BigDecimal examSecondInspectPoint) {
        this.examSecondInspectPoint = examSecondInspectPoint;
    }

    public Integer getListenFirstListenAmount() {
        return listenFirstListenAmount;
    }

    public void setListenFirstListenAmount(Integer listenFirstListenAmount) {
        this.listenFirstListenAmount = listenFirstListenAmount;
    }

    public BigDecimal getListenFirstListenPoint() {
        return listenFirstListenPoint;
    }

    public void setListenFirstListenPoint(BigDecimal listenFirstListenPoint) {
        this.listenFirstListenPoint = listenFirstListenPoint;
    }

    public Integer getListenSecondListenAmount() {
        return listenSecondListenAmount;
    }

    public void setListenSecondListenAmount(Integer listenSecondListenAmount) {
        this.listenSecondListenAmount = listenSecondListenAmount;
    }

    public BigDecimal getListenSecondListenPoint() {
        return listenSecondListenPoint;
    }

    public void setListenSecondListenPoint(BigDecimal listenSecondListenPoint) {
        this.listenSecondListenPoint = listenSecondListenPoint;
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
        return "TeachExam{" +
        "id=" + id +
        ", jobNo=" + jobNo +
        ", teacherName=" + teacherName +
        ", examFirstExamAmount=" + examFirstExamAmount +
        ", examFirstInspectPoint=" + examFirstInspectPoint +
        ", examSecondExamAmount=" + examSecondExamAmount +
        ", examSecondInspectPoint=" + examSecondInspectPoint +
        ", listenFirstListenAmount=" + listenFirstListenAmount +
        ", listenFirstListenPoint=" + listenFirstListenPoint +
        ", listenSecondListenAmount=" + listenSecondListenAmount +
        ", listenSecondListenPoint=" + listenSecondListenPoint +
        ", teacherId=" + teacherId +
        ", status=" + status +
        ", createTime=" + createTime +
        ", commitTime=" + commitTime +
        ", auditTime=" + auditTime +
        ", managerId=" + managerId +
        "}";
    }
}
