package cn.teach.mall.service.impl;

import cn.teach.common.mvc.Page;
import cn.teach.mall.mapper.TeachPractiseCompetitionMapper;
import cn.teach.mall.service.ITeachPractiseCompetitionService;
import cn.teach.pojo.mall.entity.TeachPractiseCompetition;
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
public class TeachPractiseCompetitionServiceImpl extends ServiceImpl<TeachPractiseCompetitionMapper, TeachPractiseCompetition> implements ITeachPractiseCompetitionService {

    @Override
    public IPage<TeachPractiseCompetition> pageForTeachPractiseCompetition(Page<TeachPractiseCompetition> page, Map<String, Object> param) {
        return this.baseMapper.pageForTeachPractiseCompetition(page,param);
    }
}
