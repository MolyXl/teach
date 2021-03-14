package cn.teach.mall.mapper;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.TeachPractiseCompetition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Map;

/**
 * <p>
 * 实践环节专业学科竞赛业绩点统计表 Mapper 接口
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface TeachPractiseCompetitionMapper extends BaseMapper<TeachPractiseCompetition> {

    IPage<TeachPractiseCompetition> pageForTeachPractiseCompetition(Page<TeachPractiseCompetition> page, Map<String, Object> param);
}
