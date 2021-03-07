package cn.teach.pojo.mall.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("teach_practise_other")
public class TeachPractiseOther implements Serializable {

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
     * 上半年指导毕业论文业绩点
     */
    private BigDecimal firstGraduationPoint;

    /**
     * 上半年指导学年论文业绩点
     */
    private BigDecimal firstYearPoint;

    /**
     * 上半年指导创新创业训练业绩点
     */
    private BigDecimal firstRevolutionPoint;

    /**
     * 上半年课程设计/项目课程业绩点
     */
    private BigDecimal firstCoursePoint;

    /**
     * 上半年实践环节业绩点合计(指导创新创业训练业绩点+课程设计/项目课程业绩点+指导实习/见习/考察/写生等业绩点+指导专业学科竞赛业绩点
)
     */
    private BigDecimal firstPractisePoint;

    /**
     * 下半年指导毕业论文业绩点
     */
    private BigDecimal secondGraduationPoint;

    /**
     * 下半年指导学年论文业绩点
     */
    private BigDecimal secondYearPoint;

    /**
     * 下半年指导创新创业训练业绩点
     */
    private BigDecimal secondRevolutionPoint;

    /**
     * 下半年课程设计/项目课程业绩点
     */
    private BigDecimal secondCoursePoint;

    /**
     * 下半年实践环节业绩点合计(指导创新创业训练业绩点+课程设计/项目课程业绩点+指导实习/见习/考察/写生等业绩点+指导专业学科竞赛业绩点
)
     */
    private BigDecimal secondPractisePoint;

    /**
     * 全年合计
     */
    private BigDecimal totalPoint;

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

    public BigDecimal getFirstGraduationPoint() {
        return firstGraduationPoint;
    }

    public void setFirstGraduationPoint(BigDecimal firstGraduationPoint) {
        this.firstGraduationPoint = firstGraduationPoint;
    }

    public BigDecimal getFirstYearPoint() {
        return firstYearPoint;
    }

    public void setFirstYearPoint(BigDecimal firstYearPoint) {
        this.firstYearPoint = firstYearPoint;
    }

    public BigDecimal getFirstRevolutionPoint() {
        return firstRevolutionPoint;
    }

    public void setFirstRevolutionPoint(BigDecimal firstRevolutionPoint) {
        this.firstRevolutionPoint = firstRevolutionPoint;
    }

    public BigDecimal getFirstCoursePoint() {
        return firstCoursePoint;
    }

    public void setFirstCoursePoint(BigDecimal firstCoursePoint) {
        this.firstCoursePoint = firstCoursePoint;
    }

    public BigDecimal getFirstPractisePoint() {
        return firstPractisePoint;
    }

    public void setFirstPractisePoint(BigDecimal firstPractisePoint) {
        this.firstPractisePoint = firstPractisePoint;
    }

    public BigDecimal getSecondGraduationPoint() {
        return secondGraduationPoint;
    }

    public void setSecondGraduationPoint(BigDecimal secondGraduationPoint) {
        this.secondGraduationPoint = secondGraduationPoint;
    }

    public BigDecimal getSecondYearPoint() {
        return secondYearPoint;
    }

    public void setSecondYearPoint(BigDecimal secondYearPoint) {
        this.secondYearPoint = secondYearPoint;
    }

    public BigDecimal getSecondRevolutionPoint() {
        return secondRevolutionPoint;
    }

    public void setSecondRevolutionPoint(BigDecimal secondRevolutionPoint) {
        this.secondRevolutionPoint = secondRevolutionPoint;
    }

    public BigDecimal getSecondCoursePoint() {
        return secondCoursePoint;
    }

    public void setSecondCoursePoint(BigDecimal secondCoursePoint) {
        this.secondCoursePoint = secondCoursePoint;
    }

    public BigDecimal getSecondPractisePoint() {
        return secondPractisePoint;
    }

    public void setSecondPractisePoint(BigDecimal secondPractisePoint) {
        this.secondPractisePoint = secondPractisePoint;
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
        return "TeachPractiseOther{" +
        "id=" + id +
        ", jobNo=" + jobNo +
        ", teacherName=" + teacherName +
        ", firstGraduationPoint=" + firstGraduationPoint +
        ", firstYearPoint=" + firstYearPoint +
        ", firstRevolutionPoint=" + firstRevolutionPoint +
        ", firstCoursePoint=" + firstCoursePoint +
        ", firstPractisePoint=" + firstPractisePoint +
        ", secondGraduationPoint=" + secondGraduationPoint +
        ", secondYearPoint=" + secondYearPoint +
        ", secondRevolutionPoint=" + secondRevolutionPoint +
        ", secondCoursePoint=" + secondCoursePoint +
        ", secondPractisePoint=" + secondPractisePoint +
        ", totalPoint=" + totalPoint +
        ", teacherId=" + teacherId +
        ", status=" + status +
        ", createTime=" + createTime +
        ", commitTime=" + commitTime +
        ", auditTime=" + auditTime +
        ", managerId=" + managerId +
        "}";
    }
}
