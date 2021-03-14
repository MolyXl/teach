package cn.teach.mall.mapper;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.ForeignPractise;
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
public interface ForeignPractiseMapper extends BaseMapper<ForeignPractise> {

    IPage<ForeignPractise> pageForForeignPractise(Page<ForeignPractise> page, Map<String, Object> param);
}
