package cn.teach.pojo.mall.enums;

import java.util.*;

/**
 * @ClassName: ProductStatusEnum
 * @Description: 商品上下架状态
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum ProductStatusEnum {

    RACKING(0, "已上架"),      //上架
    SOLD_OUT(1, "已下架");     //下架


    private Map<Integer, String> status;

    ProductStatusEnum(Integer status, String value) {
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
        List<ProductStatusEnum> productStatusEnums = Arrays.asList(ProductStatusEnum.values());
        Optional<ProductStatusEnum> first = productStatusEnums.stream().filter(c -> c.getKey().equals(status)).findFirst();
        if (first.isPresent()) {
            return first.get().getValue();
        }
        return null;
    }
}
