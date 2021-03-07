package cn.teach.pojo.mall.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 实践环节毕业论文、学年论文、创新创业训练计划项目等业绩点统计表
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@TableName("teach_practise_paper")
public class TeachPractisePaper implements Serializable {

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
     * 环节类型(1,指导创新创业训练;2,指导毕业论文;3,指导学年论文)
     */
    private String linkType;

    /**
     * 学生对象（班级名称）
     */
    private String className;

    /**
     * 指导毕业论文人数
     */
    private Integer studentAmount;

    /**
     * 毕业设计类型
     */
    private String designType;

    /**
     * 指导毕业论文业绩点
     */
    private BigDecimal paperPoint;

    /**
     * 指导学年论文人数
     */
    private Integer paperStudentAmount;

    /**
     * 指导学年论文业绩点
     */
    private BigDecimal totalPaperAmount;

    /**
     * 指导创新创业训练级别(1,国家级立项;2,校级一等奖;3,校级二等奖;4,校级三等奖;5,校级结项)
     */
    private String innovativeLevel;

    /**
     * 指导创新创业训练业绩点
     */
    private String innovativePoint;

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

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getClassName() {
        return className;
    }

    public void setClass(String className) {
        this.className = className;
    }

    public Integer getStudentAmount() {
        return studentAmount;
    }

    public void setStudentAmount(Integer studentAmount) {
        this.studentAmount = studentAmount;
    }

    public String getDesignType() {
        return designType;
    }

    public void setDesignType(String designType) {
        this.designType = designType;
    }

    public BigDecimal getPaperPoint() {
        return paperPoint;
    }

    public void setPaperPoint(BigDecimal paperPoint) {
        this.paperPoint = paperPoint;
    }

    public Integer getPaperStudentAmount() {
        return paperStudentAmount;
    }

    public void setPaperStudentAmount(Integer paperStudentAmount) {
        this.paperStudentAmount = paperStudentAmount;
    }

    public BigDecimal getTotalPaperAmount() {
        return totalPaperAmount;
    }

    public void setTotalPaperAmount(BigDecimal totalPaperAmount) {
        this.totalPaperAmount = totalPaperAmount;
    }

    public String getInnovativeLevel() {
        return innovativeLevel;
    }

    public void setInnovativeLevel(String innovativeLevel) {
        this.innovativeLevel = innovativeLevel;
    }

    public String getInnovativePoint() {
        return innovativePoint;
    }

    public void setInnovativePoint(String innovativePoint) {
        this.innovativePoint = innovativePoint;
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
        return "TeachPractisePaper{" +
        "id=" + id +
        ", jobNo=" + jobNo +
        ", teacherName=" + teacherName +
        ", linkType=" + linkType +
        ", className=" + className +
        ", studentAmount=" + studentAmount +
        ", designType=" + designType +
        ", paperPoint=" + paperPoint +
        ", paperStudentAmount=" + paperStudentAmount +
        ", totalPaperAmount=" + totalPaperAmount +
        ", innovativeLevel=" + innovativeLevel +
        ", innovativePoint=" + innovativePoint +
        ", teacherId=" + teacherId +
        ", status=" + status +
        ", createTime=" + createTime +
        ", commitTime=" + commitTime +
        ", auditTime=" + auditTime +
        ", managerId=" + managerId +
        "}";
    }
}
