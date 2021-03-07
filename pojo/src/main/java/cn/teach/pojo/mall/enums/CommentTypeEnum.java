package cn.teach.pojo.mall.enums;

import java.util.*;

/**
 * @ClassName: CommentTypeEnum
 * @Description: 评价类型
 * @Author: MaZhuli
 * @Date: 2019/7/31 16:10
 * @Version: 1.0.0
 */
public enum CommentTypeEnum {
    All(0,"全部"),        //全部
    GOOD(1,"好评"),       //好评
    COMMON(2,"中评"),     //中评
    BAD(3,"差评"),        //差评
    HAS_PIC(4,"有图");    //有图

    private Map<Integer, String> status;

    CommentTypeEnum(Integer key, String value) {
        this.status = new HashMap();
        this.status.put(key, value);

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
        List<CommentTypeEnum> commentTypeEnums = Arrays.asList(CommentTypeEnum.values());
        Optional<CommentTypeEnum> first = commentTypeEnums.stream().filter(c -> c.getKey().equals(status)).findFirst();
        if (first.isPresent()) {
            return first.get().getValue();
        }
        return null;
    }
}
