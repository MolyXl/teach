package cn.teach.mall.mapper;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.TeachCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Map;

/**
 * <p>
 * 课堂教学及评卷业绩点统计表 Mapper 接口
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface TeachCourseMapper extends BaseMapper<TeachCourse> {

    IPage<TeachCourse> pageForTeachCourse(Page<TeachCourse> page, Map<String, Object> param);
}

