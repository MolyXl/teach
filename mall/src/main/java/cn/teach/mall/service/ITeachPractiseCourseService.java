package cn.teach.mall.service;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.TeachPractiseCourse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 实践环节课程设计/项目课程等业绩点统计表 服务类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface ITeachPractiseCourseService extends IService<TeachPractiseCourse> {

    IPage<TeachPractiseCourse> pageForTeachPractiseCourse(Page<TeachPractiseCourse> page, Map<String, Object> param);
}
