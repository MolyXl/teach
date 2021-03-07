package cn.teach.pojo.mall.enums;

import java.util.*;

/**
 * @ClassName: CreditTypeEnum
 * @Description: 打款类型
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum RemitTypeEnum {

    OFFLINE(0, "确认线下打款"),
    ONLINE(1, "自动线上打款");

    private Map<Integer, String> type;

    RemitTypeEnum(Integer type, String value) {
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
        List<RemitTypeEnum> slideShowTypeEnums = Arrays.asList(RemitTypeEnum.values());
        Optional<RemitTypeEnum> first = slideShowTypeEnums.stream().filter(c -> c.getKey().equals(type)).findFirst();
        if (first.isPresent()) {
            return first.get().getValue();
        }
        return null;
    }
}
