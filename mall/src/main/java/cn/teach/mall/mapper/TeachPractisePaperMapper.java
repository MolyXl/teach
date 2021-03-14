package cn.teach.mall.mapper;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.TeachPractisePaper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Map;

/**
 * <p>
 * 实践环节毕业论文、学年论文、创新创业训练计划项目等业绩点统计表 Mapper 接口
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface TeachPractisePaperMapper extends BaseMapper<TeachPractisePaper> {

    IPage<TeachPractisePaper> pageForTeachPractisePaper(Page<TeachPractisePaper> page, Map<String, Object> param);
}
