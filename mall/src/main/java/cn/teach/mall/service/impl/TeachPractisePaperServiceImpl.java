package cn.teach.mall.service.impl;

import cn.teach.common.mvc.Page;
import cn.teach.mall.mapper.TeachPractisePaperMapper;
import cn.teach.mall.service.ITeachPractisePaperService;
import cn.teach.pojo.mall.entity.TeachPractisePaper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 实践环节毕业论文、学年论文、创新创业训练计划项目等业绩点统计表 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@Service
public class TeachPractisePaperServiceImpl extends ServiceImpl<TeachPractisePaperMapper, TeachPractisePaper> implements ITeachPractisePaperService {

    @Override
    public IPage<TeachPractisePaper> pageForTeachPractisePaper(Page<TeachPractisePaper> page, Map<String, Object> param) {
        return this.baseMapper.pageForTeachPractisePaper(page,param);
    }
}
