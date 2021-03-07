package cn.teach.pojo.mall.enums;

/**
 * @ClassName: FileTypeEnum
 * @Description: 文件类型
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum FileTypeEnum {

    PRODUCT("PRODUCT"),                     //商品
    CREDIT_PRODUCT("CREDIT_PRODUCT"),       //积分商品
    COMMENT("COMMENT");                     //评价

    private String type;

    FileTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
