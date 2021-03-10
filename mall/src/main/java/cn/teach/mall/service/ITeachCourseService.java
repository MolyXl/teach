package cn.teach.mall.service;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.TeachCourse;
import cn.teach.pojo.mall.entity.TeachTeaching;
import cn.teach.pojo.mall.vo.RoleVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 课堂教学及评卷业绩点统计表 服务类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface ITeachCourseService extends IService<TeachCourse> {
    IPage<TeachCourse> pageForTeachCourse(Page<TeachCourse> page, Map<String, Object> param);
}
