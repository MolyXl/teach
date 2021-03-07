package cn.teach.pojo.mall.enums;

import java.util.*;

/**
 * @ClassName: AdTypeEnum
 * @Description: 广告类型
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum ArticleTypeEnum {

    PLATFORM(2, "品牌介绍"),
    AGREEMENT(3, "注册协议"),
    PROMISE(4, "品质承诺"),
    COIN_BOOK(5, "玉币说明"),
    CREDIT_BOOK(6, "积分说明"),
    INCOME_BOOK(7, "收入说明"),
    OPERATE_BOOK(8, "操作指南"),
    SIGN_RULE(9, "签到规则");

    private Map<Integer, String> type;

    ArticleTypeEnum(Integer type, String value) {
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
        List<ArticleTypeEnum> coinTypeEnums = Arrays.asList(ArticleTypeEnum.values());
        Optional<ArticleTypeEnum> first = coinTypeEnums.stream().filter(c -> c.getKey().equals(type)).findFirst();
        if (first.isPresent()) {
            return first.get().getValue();
        }
        return null;
    }

    public static List<Map> getKeyValueList() {
        List<ArticleTypeEnum> adTypeEnumList = Arrays.asList(ArticleTypeEnum.values());
        List<Map> list = new ArrayList<>();
        for (ArticleTypeEnum adTypeEnum : adTypeEnumList) {
            Map map = new HashMap();
            map.put("value", adTypeEnum.getKey());
            map.put("name", adTypeEnum.getValue());
            list.add(map);
        }
        return list;
    }
}
