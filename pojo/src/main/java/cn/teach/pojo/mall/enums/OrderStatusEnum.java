package cn.teach.pojo.mall.enums;

import java.util.*;

/**
 * @ClassName: OrderStatusEnum
 * @Description: 订单状态
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum OrderStatusEnum {

    TO_PAY(1, "待支付"),      //待支付
    TO_DELIVER(2, "待发货"),  //待发货/已支付
    CANCEL(3, "已取消"),      //已取消
    TO_RECEIVE(4, "待收货"),  //待收货/配送中
    TO_COMMENT(5, "待评价"),  //待评价/已收货
    DONE(6, "已完成");        //已完成

    private Map<Integer, String> status;

    OrderStatusEnum(Integer status, String value) {
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
        List<OrderStatusEnum> orderStatusEnums = Arrays.asList(OrderStatusEnum.values());
        Optional<OrderStatusEnum> first = orderStatusEnums.stream().filter(c -> c.getKey().equals(status)).findFirst();
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
