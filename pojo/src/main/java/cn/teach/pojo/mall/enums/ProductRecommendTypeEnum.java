package cn.teach.pojo.mall.enums;

import java.util.*;

/**
 * @ClassName: ProductRecommendTypeEnum
 * @Description: 商品推荐分类
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum ProductRecommendTypeEnum {

    NEW(1, "新品"),     //新品
    HOT(2, "热卖");     //热卖

    private Map<Integer, String> type;

    ProductRecommendTypeEnum(Integer type, String value) {
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
        List<ProductRecommendTypeEnum> productRecommendTypeEnums = Arrays.asList(ProductRecommendTypeEnum.values());
        Optional<ProductRecommendTypeEnum> first = productRecommendTypeEnums.stream().filter(c -> c.getKey().equals(type)).findFirst();
        if (first.isPresent()) {
            return first.get().getValue();
        }
        return null;
    }
}
