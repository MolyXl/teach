package cn.teach.pojo.mall.enums;

import java.util.*;

/**
 * @ClassName: CreditTypeEnum
 * @Description: 玉币类型
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum IncomeTypeEnum {

    BUY(1, "购买"),         //购买
    RECOMMEND(2, "推广"),   //推广
    WITHDRAW(3, "提现"),    //提现
    REFUSE(4, "提现驳回");  //提现驳回

    private Map<Integer, String> type;

    IncomeTypeEnum(Integer type, String value) {
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
        List<IncomeTypeEnum> incomeTypeEnums = Arrays.asList(IncomeTypeEnum.values());
        Optional<IncomeTypeEnum> first = incomeTypeEnums.stream().filter(c -> c.getKey().equals(type)).findFirst();
        if (first.isPresent()) {
            return first.get().getValue();
        }
        return null;
    }
}
