package cn.teach.mall.service.impl;

import cn.teach.common.mvc.Page;
import cn.teach.mall.mapper.TeachRevolutionMapper;
import cn.teach.mall.service.ITeachRevolutionService;
import cn.teach.pojo.mall.entity.TeachRevolution;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 教学改革增量业绩点统计表 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@Service
public class TeachRevolutionServiceImpl extends ServiceImpl<TeachRevolutionMapper, TeachRevolution> implements ITeachRevolutionService {

    @Override
    public IPage<TeachRevolution> pageForTeachRevolution(Page<TeachRevolution> page, Map<String, Object> param) {
        return this.baseMapper.pageForTeachRevolution(page,param);
    }
}
