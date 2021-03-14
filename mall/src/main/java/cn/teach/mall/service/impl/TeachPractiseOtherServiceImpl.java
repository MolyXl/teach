package cn.teach.mall.service.impl;

import cn.teach.common.mvc.Page;
import cn.teach.mall.mapper.TeachPractiseOtherMapper;
import cn.teach.mall.service.ITeachPractiseOtherService;
import cn.teach.pojo.mall.entity.TeachPractiseOther;
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
public class TeachPractiseOtherServiceImpl extends ServiceImpl<TeachPractiseOtherMapper, TeachPractiseOther> implements ITeachPractiseOtherService {

    @Override
    public IPage<TeachPractiseOther> pageForTeachPractiseOther(Page<TeachPractiseOther> page, Map<String, Object> param) {
        return this.baseMapper.pageForTeachPractiseOther(page,param);
    }
}
