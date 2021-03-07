package cn.teach.pojo.mall.enums;

/**
 * @ClassName: IsOrNotEnum
 * @Description: 财务日志类型
 * @Author: MaZhuli
 * @Date: 2019/7/31 14:43
 * @Version: 1.0.0
 */
public enum FinanceLogTypeEnums {

    ORDER(1),       //订单支付
    WITHDRAW(2);    //提现支付

    private Integer type;

    FinanceLogTypeEnums(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
