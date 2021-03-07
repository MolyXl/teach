package cn.teach.pojo.mall.enums;

import java.util.*;

/**
 * @ClassName: CreditTypeEnum
 * @Description: 玉币类型
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum CoinTypeEnum {

    RECOMMEND(1, "推广收入"),     //推广
    EXCHANGE(2, "玉币抵现"),      //抵现
    RETURN(3, "订单退还");        //退还

    private Map<Integer, String> type;

    CoinTypeEnum(Integer type, String value) {
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
        List<CoinTypeEnum> coinTypeEnums = Arrays.asList(CoinTypeEnum.values());
        Optional<CoinTypeEnum> first = coinTypeEnums.stream().filter(c -> c.getKey().equals(type)).findFirst();
        if (first.isPresent()) {
            return first.get().getValue();
        }
        return null;
    }
}
