package cn.teach.mall.service.impl;

import cn.teach.common.mvc.Page;
import cn.teach.mall.mapper.TeachPractiseCourseMapper;
import cn.teach.mall.service.ITeachPractiseCourseService;
import cn.teach.pojo.mall.entity.TeachPractiseCourse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 实践环节课程设计/项目课程等业绩点统计表 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@Service
public class TeachPractiseCourseServiceImpl extends ServiceImpl<TeachPractiseCourseMapper, TeachPractiseCourse> implements ITeachPractiseCourseService {

    @Override
    public IPage<TeachPractiseCourse> pageForTeachPractiseCourse(Page<TeachPractiseCourse> page, Map<String, Object> param) {
        return this.baseMapper.pageForTeachPractiseCourse(page,param);
    }
}
