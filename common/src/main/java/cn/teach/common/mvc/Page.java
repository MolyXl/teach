package cn.teach.common.mvc;

/**
 * @ClassName Page
 * @Author LiZhuang
 * @Date 2019/3/11 17:02
 * @Description 重写某些构造方法
 * @Version 1.0
 **/
public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> {
    private static final long serialVersionUID = 1774488627883876793L;

    public Page(Integer pageNow, Integer pageSize) {
        if(pageNow==null){
            this.setCurrent(1);
        }else{
            this.setCurrent(pageNow);
        }
        if(pageSize==null){
            this.setSize(10);
        }else {
            this.setSize(pageSize);
        }
    }
}
