package cn.teach.mall.service.impl;

import cn.teach.common.mvc.Page;
import cn.teach.mall.mapper.TeachPractiseInspectMapper;
import cn.teach.mall.service.ITeachPractiseInspectService;
import cn.teach.pojo.mall.entity.TeachPractiseInspect;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 实践环节专业学科竞赛业绩点统计表 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@Service
public class TeachPractiseInspectServiceImpl extends ServiceImpl<TeachPractiseInspectMapper, TeachPractiseInspect> implements ITeachPractiseInspectService {

    @Override
    public IPage<TeachPractiseInspect> pageForTeachPractiseInspect(Page<TeachPractiseInspect> page, Map<String, Object> param) {
        return this.baseMapper.pageForTeachPractiseInspect(page,param);
    }
}
