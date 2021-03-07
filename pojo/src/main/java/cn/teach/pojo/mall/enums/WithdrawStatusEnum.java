package cn.teach.pojo.mall.enums;

import java.util.*;

/**
 * @ClassName: ProductStatusEnum
 * @Description: 提现状态
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum WithdrawStatusEnum {

    IN_HAND(1,"处理中"),     //处理中
    REMITED(2,"已打款"),     //已打款
    REFUSED(3,"已驳回");     //已驳回


    private Map<Integer, String> status;

    WithdrawStatusEnum(Integer status, String value) {
        this.status = new HashMap();
        this.status.put(status, value);

    }

    public Map getType() {
        return status;
    }

    public Integer getKey() {
        Set<Integer> keys = this.status.keySet();
        return (Integer) keys.toArray()[0];
    }

    public String getValue() {
        Set<Integer> keys = this.status.keySet();
        return this.status.get(keys.toArray()[0]);
    }

    public static String getTypeValue(Integer status) {
        List<WithdrawStatusEnum> withdrawStatusEnums = Arrays.asList(WithdrawStatusEnum.values());
        Optional<WithdrawStatusEnum> first = withdrawStatusEnums.stream().filter(c -> c.getKey().equals(status)).findFirst();
        if (first.isPresent()) {
            return first.get().getValue();
        }
        return null;
    }

    public static List<Map> getKeyValueList() {
        List<OrderStatusEnum> orderStatusEnums = Arrays.asList(OrderStatusEnum.values());
        List<Map> list = new ArrayList<>();
        for (OrderStatusEnum orderStatusEnum : orderStatusEnums) {
            Map map = new HashMap();
            map.put("value", orderStatusEnum.getKey());
            map.put("name", orderStatusEnum.getValue());
            list.add(map);
        }
        return list;
    }
}
