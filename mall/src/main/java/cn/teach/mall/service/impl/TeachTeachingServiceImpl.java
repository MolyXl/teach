package cn.teach.mall.service.impl;

import cn.teach.common.mvc.Page;
import cn.teach.mall.mapper.TeachTeachingMapper;
import cn.teach.mall.service.ITeachTeachingService;
import cn.teach.pojo.mall.entity.TeachTeaching;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 教师教学工作量汇总表 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@Service
public class TeachTeachingServiceImpl extends ServiceImpl<TeachTeachingMapper, TeachTeaching> implements ITeachTeachingService {

    @Override
    public IPage<TeachTeaching> pageForTeachTeaching(Page<TeachTeaching> page, Map<String, Object> param) {
        return this.baseMapper.pageForTeachTeaching(page,param);
    }

}
