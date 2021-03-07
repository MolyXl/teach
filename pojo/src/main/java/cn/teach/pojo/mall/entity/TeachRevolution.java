package cn.teach.pojo.mall.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 教学改革增量业绩点统计表
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@TableName("teach_revolution")
public class TeachRevolution implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 类型(1,教学改革项目类;2,新专业申报建设;3,安师讲坛;4,政治理论报告;5,教研成果类)
     */
    private String type;

    /**
     * 本科教学工程类别(1,专业综合改革试点;2,人才培养模式改革试点;3,卓越计划项目;4,专业核心课程示范群;5,精品资源共享课;7精品视频公开课;8,双语教学示范课
教学团队;9,大学生校外实践基地;10,实验教学示范中心;11,精品在线开放课程;12,基层教学组织;13,特色专业
教学研究项目;14,教学成果奖;15,虚拟仿真实验教学中心;16,无)
     */
    private String course;

    /**
     * 级别(1,国家级;2,省级;3,地厅级;4,校级)
     */
    private String level;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 立项年月
     */
    private String approvalDate;

    /**
     * 建设周期
     */
    private String buildPeriod;

    /**
     * 年度建设任务完成情况(1,是;2,否)
     */
    private String yearFinishStatus;

    /**
     * 项目建设情况(1,在建;2,结项)
     */
    private String projectBuildStatus;

    /**
     * 项目负责人
     */
    private String chargeMan;

    /**
     * 当年业绩点
     */
    private BigDecimal yearPoint;

    /**
     * 本项目总业绩点
     */
    private BigDecimal projectPoint;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getBuildPeriod() {
        return buildPeriod;
    }

    public void setBuildPeriod(String buildPeriod) {
        this.buildPeriod = buildPeriod;
    }

    public String getYearFinishStatus() {
        return yearFinishStatus;
    }

    public void setYearFinishStatus(String yearFinishStatus) {
        this.yearFinishStatus = yearFinishStatus;
    }

    public String getProjectBuildStatus() {
        return projectBuildStatus;
    }

    public void setProjectBuildStatus(String projectBuildStatus) {
        this.projectBuildStatus = projectBuildStatus;
    }

    public String getChargeMan() {
        return chargeMan;
    }

    public void setChargeMan(String chargeMan) {
        this.chargeMan = chargeMan;
    }

    public BigDecimal getYearPoint() {
        return yearPoint;
    }

    public void setYearPoint(BigDecimal yearPoint) {
        this.yearPoint = yearPoint;
    }

    public BigDecimal getProjectPoint() {
        return projectPoint;
    }

    public void setProjectPoint(BigDecimal projectPoint) {
        this.projectPoint = projectPoint;
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
        return "TeachRevolution{" +
        "id=" + id +
        ", type=" + type +
        ", course=" + course +
        ", level=" + level +
        ", projectName=" + projectName +
        ", approvalDate=" + approvalDate +
        ", buildPeriod=" + buildPeriod +
        ", yearFinishStatus=" + yearFinishStatus +
        ", projectBuildStatus=" + projectBuildStatus +
        ", chargeMan=" + chargeMan +
        ", yearPoint=" + yearPoint +
        ", projectPoint=" + projectPoint +
        ", teacherId=" + teacherId +
        ", status=" + status +
        ", createTime=" + createTime +
        ", commitTime=" + commitTime +
        ", auditTime=" + auditTime +
        ", managerId=" + managerId +
        "}";
    }
}
