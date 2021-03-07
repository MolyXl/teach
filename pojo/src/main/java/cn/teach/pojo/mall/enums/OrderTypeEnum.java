package cn.teach.pojo.mall.enums;

/**
 * @ClassName: OrderStatusEnum
 * @Description: 订单类型
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum OrderTypeEnum {

    PRODUCT_ORDER(1),           //商城订单
    CREDIT_PRODUCT_ORDER(2);   //积分商城订单

    private Integer type;

    OrderTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
