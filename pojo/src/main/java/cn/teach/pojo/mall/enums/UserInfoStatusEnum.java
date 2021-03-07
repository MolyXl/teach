package cn.teach.pojo.mall.enums;

/**
 * @ClassName: UserInfoStatusEnum
 * @Description: 用户信息审核状态
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum UserInfoStatusEnum {

    TO_AUDIT(1),    //待审核
    APPROVE(2),     //审核通过
    REFUSE(3);      //审核拒绝

    private Integer status;

    UserInfoStatusEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
