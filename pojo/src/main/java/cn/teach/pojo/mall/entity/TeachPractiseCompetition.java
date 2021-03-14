package cn.teach.pojo.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 实践环节专业学科竞赛业绩点统计表
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@TableName("teach_practise_competition")
public class TeachPractiseCompetition implements Serializable {

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
     * 专业学科竞赛名称
     */
    private String competitionName;

    /**
     * 指导专业学科竞赛级别(1,省级;2,国家级)
     */
    private String competitionLevel;

    /**
     * 指导专业学科竞赛参赛人数
     */
    private Integer competitionAmount;

    /**
     * 指导专业学科竞赛业绩点
     */
    private String competitionPoint;

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

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getCompetitionLevel() {
        return competitionLevel;
    }

    public void setCompetitionLevel(String competitionLevel) {
        this.competitionLevel = competitionLevel;
    }

    public Integer getCompetitionAmount() {
        return competitionAmount;
    }

    public void setCompetitionAmount(Integer competitionAmount) {
        this.competitionAmount = competitionAmount;
    }

    public String getCompetitionPoint() {
        return competitionPoint;
    }

    public void setCompetitionPoint(String competitionPoint) {
        this.competitionPoint = competitionPoint;
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
        return "TeachPractiseCompetition{" +
        "id=" + id +
        ", jobNo=" + jobNo +
        ", teacherName=" + teacherName +
        ", competitionName=" + competitionName +
        ", competitionLevel=" + competitionLevel +
        ", competitionAmount=" + competitionAmount +
        ", competitionPoint=" + competitionPoint +
        ", teacherId=" + teacherId +
        ", status=" + status +
        ", createTime=" + createTime +
        ", commitTime=" + commitTime +
        ", auditTime=" + auditTime +
        ", managerId=" + managerId +
        "}";
    }

}
