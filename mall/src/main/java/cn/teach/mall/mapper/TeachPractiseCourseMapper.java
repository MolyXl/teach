package cn.teach.mall.mapper;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.TeachPractiseCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Map;

/**
 * <p>
 * 实践环节课程设计/项目课程等业绩点统计表 Mapper 接口
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface TeachPractiseCourseMapper extends BaseMapper<TeachPractiseCourse> {

     IPage<TeachPractiseCourse> pageForTeachPractiseCourse(Page<TeachPractiseCourse> page, Map<String, Object> param);
}
