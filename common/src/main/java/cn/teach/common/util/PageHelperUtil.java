package cn.teach.common.util;

import cn.teach.common.mvc.Page;
import cn.teach.common.mvc.PageResult;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PageHelperUtil
 * @Author ChenYang
 * @Date 2018/10/11 11:20
 * @Description 分页辅助
 * @Version 1.0
 **/

public class PageHelperUtil {
    /**
     * @Author ChenYang
     * @Description 分页辅助
     * @Date 2018/10/11 14:31
     * @Param [map]
     * @Return java.util.Map<java.lang.String, java.lang.Integer>
     **/

    public static Map<String, Integer> getPageInfo(Integer page, Integer limit) {
        Map<String, Integer> pageMap = new HashMap<>();
        int pageNum = 1;
        int pageSize = 10;
        if (page != null) {
            pageNum = page;
        }
        if (limit != null) {
            pageSize = limit;
        }
        pageMap.put("page", pageNum);
        pageMap.put("limit", pageSize);
        return pageMap;
    }

    /**
     * @Author MaZhuli
     * @Description 分页返回
     * @Date 2019/3/5 18:14
     * @Param [list, totalCount]
     * @Return cn.teach.mvc.PageResult<?>
     **/
    public static <T> PageResult<T> setResult(List<T> list) {
        com.github.pagehelper.PageInfo page = new PageInfo(list);
        long totalNum = page.getTotal();
        Integer pageSize = page.getPageSize();
        PageResult<T> pageResult = new PageResult<T>(list, totalNum, pageSize);
        return pageResult;
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/16
     * @Description: 获取分页数据
     */
    public static Page getPageInfo(Map<String, Object> map) {
        int page = 1;
        int limit = 10;
        if (map.get("page") != null) {
            page = Integer.parseInt(String.valueOf(map.get("page")));
        }
        if (map.get("limit") != null) {
            limit = Integer.parseInt(String.valueOf(map.get("limit")));
        }
        return new Page<>(page, limit);
    }
}

