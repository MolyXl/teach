package cn.teach.mall.mapper;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.TeachRevolution;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Map;

/**
 * <p>
 * 教学改革增量业绩点统计表 Mapper 接口
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface TeachRevolutionMapper extends BaseMapper<TeachRevolution> {

    IPage<TeachRevolution> pageForTeachRevolution(Page<TeachRevolution> page, Map<String, Object> param);
}
