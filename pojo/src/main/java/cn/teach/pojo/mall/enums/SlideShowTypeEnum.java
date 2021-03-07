package cn.teach.pojo.mall.enums;

import java.util.*;

/**
 * @ClassName: CreditTypeEnum
 * @Description: 轮播图类型
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum SlideShowTypeEnum {

    PICTURES(1, "图文"),  //图文
    LINK(2, "链接"),      //链接
    PRODUCT(3, "商品");   //商品

    private Map<Integer, String> type;

    SlideShowTypeEnum(Integer type, String value) {
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
        List<SlideShowTypeEnum> slideShowTypeEnums = Arrays.asList(SlideShowTypeEnum.values());
        Optional<SlideShowTypeEnum> first = slideShowTypeEnums.stream().filter(c -> c.getKey().equals(type)).findFirst();
        if (first.isPresent()) {
            return first.get().getValue();
        }
        return null;
    }
}
