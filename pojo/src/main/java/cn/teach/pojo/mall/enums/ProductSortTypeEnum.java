package cn.teach.pojo.mall.enums;

/**
 * @ClassName: ProductSortTypeEnum
 * @Description: 商品排序方式
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum ProductSortTypeEnum {
    PRICE(1),           //价格
    SALES_VOLUME(2),    //销量
    CLICK(3),           //点击量
    COLLECT(4),         //收藏
    RATE(5);            //好评率

    private Integer status;

    ProductSortTypeEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
