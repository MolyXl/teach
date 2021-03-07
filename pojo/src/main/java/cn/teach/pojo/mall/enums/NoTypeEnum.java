package cn.teach.pojo.mall.enums;

/**
 * @ClassName: NoTypeEnum
 * @Description: 编号类型
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum NoTypeEnum {

    ORDER("ORDER"),                 //商品订单
    PRODUCT("PRODUCT"),             //商品
    CREDIT_ORDER("CREDIT_ORDER"),   //积分商品订单
    WITHDRAW("WITHDRAW"),           //提现
    FINANCELOG("FINANCELOG");       //提现

    private String type;

    NoTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
