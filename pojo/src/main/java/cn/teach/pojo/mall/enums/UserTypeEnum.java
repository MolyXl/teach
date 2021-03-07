package cn.teach.pojo.mall.enums;

import java.util.*;

/**
 * @ClassName: CreditTypeEnum
 * @Description: 用户类型
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum UserTypeEnum {

    COMMON_USER(1, "普通用户"),     //用户
    CUSTOMER(2, "认证会员"),        //认证会员
    AGENT(3, "经销商");            //经销商

    private Map<Integer, String> type;

    UserTypeEnum(Integer type, String value) {
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
        List<UserTypeEnum> slideShowTypeEnums = Arrays.asList(UserTypeEnum.values());
        Optional<UserTypeEnum> first = slideShowTypeEnums.stream().filter(c -> c.getKey().equals(type)).findFirst();
        if (first.isPresent()) {
            return first.get().getValue();
        }
        return null;
    }
}
