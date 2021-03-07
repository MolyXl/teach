package cn.teach.pojo.mall.enums;

import java.util.*;

/**
 * @ClassName: AdTypeEnum
 * @Description: 广告类型
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum AdTypeEnum {

    VIDEO(1, "平台视频"),               //平台视频
    ACTIVITY(2, "活动图片"),            //活动图片
    PRODUCT(3, "商品图片"),             //商品图片
    CREDIT_PRODUCT(4, "积分商品"),      //积分商品
    RECOMMEND_PRODUCT(5, "推荐商品"),   //推荐商品
    PUBLICITY(6, "宣传图片"),           //宣传图片
    COMPANY(7, "公司介绍");             //公司介绍

    private Map<Integer, String> type;

    AdTypeEnum(Integer type, String value) {
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
        List<AdTypeEnum> coinTypeEnums = Arrays.asList(AdTypeEnum.values());
        Optional<AdTypeEnum> first = coinTypeEnums.stream().filter(c -> c.getKey().equals(type)).findFirst();
        if (first.isPresent()) {
            return first.get().getValue();
        }
        return null;
    }

    public static List<Map> getKeyValueList() {
        List<AdTypeEnum> adTypeEnumList = Arrays.asList(AdTypeEnum.values());
        List<Map> list = new ArrayList<>();
        for (AdTypeEnum adTypeEnum : adTypeEnumList) {
            Map map = new HashMap();
            map.put("value", adTypeEnum.getKey());
            map.put("name", adTypeEnum.getValue());
            list.add(map);
        }
        return list;
    }
}
