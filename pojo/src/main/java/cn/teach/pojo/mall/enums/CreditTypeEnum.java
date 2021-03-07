package cn.teach.pojo.mall.enums;

import java.util.*;

/**
 * @ClassName: CreditTypeEnum
 * @Description: 积分类型
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum CreditTypeEnum {

    REGISTER(1, "新用户注册"),      //注册
    RECOMMEND(2, "邀请好友"),       //推荐
    BUY(3, "购买商品"),             //购买
    SIGN(4, "签到"),                //签到
    EXCHANGE(5, "兑换奖品");        //兑换

    private Map<Integer, String> type;

    CreditTypeEnum(Integer type, String value) {
        this.type = new HashMap();
        this.type.put(type, value);

    }

    public Map getType() {
        return type;
    }

    public Integer getKey() {
        Set<Integer> keys = this.type.keySet();
        return (Integer) keys.toArray()[0];
    }

    public String getValue() {
        Set<Integer> keys = this.type.keySet();
        return this.type.get(keys.toArray()[0]);
    }

    public static String getTypeValue(Integer type) {
        List<CreditTypeEnum> creditTypeEnums = Arrays.asList(CreditTypeEnum.values());
        Optional<CreditTypeEnum> first = creditTypeEnums.stream().filter(c -> c.getKey().equals(type)).findFirst();
        if (first.isPresent()) {
            return first.get().getValue();
        }
        return null;
    }
}
