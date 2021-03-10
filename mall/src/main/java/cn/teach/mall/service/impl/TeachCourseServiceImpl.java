package cn.teach.mall.service.impl;

import cn.teach.common.mvc.Page;
import cn.teach.mall.mapper.TeachCourseMapper;
import cn.teach.mall.service.ITeachCourseService;
import cn.teach.pojo.mall.entity.TeachCourse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 课堂教学及评卷业绩点统计表 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@Service
public class TeachCourseServiceImpl extends ServiceImpl<TeachCourseMapper, TeachCourse> implements ITeachCourseService {

    @Override
    public IPage<TeachCourse> pageForTeachCourse(Page<TeachCourse> page, Map<String, Object> param) {
        return this.baseMapper.pageForTeachCourse(page,param);
    }
}
