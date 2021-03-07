package cn.teach.pojo.mall.enums;

/**
 * @ClassName: IsOrNotEnum
 * @Description: 是否枚举
 * @Author: MaZhuli
 * @Date: 2019/7/31 14:43
 * @Version: 1.0.0
 */
public enum IsOrNotEnums {
    IS(1),
    NOT(0);

    private Integer status;

    IsOrNotEnums(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
