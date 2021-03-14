package cn.teach.mall.mapper;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.ForeignWork;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Map;

/**
 * <p>
 * 外聘工作量汇总表 Mapper 接口
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface ForeignWorkMapper extends BaseMapper<ForeignWork> {

    IPage<ForeignWork> pageForForeignWork(Page<ForeignWork> page, Map<String, Object> param);
}
