package cn.teach.mall.service.impl;

import cn.teach.common.mvc.Page;
import cn.teach.mall.mapper.TeachExamMapper;
import cn.teach.mall.service.ITeachExamService;
import cn.teach.pojo.mall.entity.TeachExam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 监考听课业绩点统计表 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@Service
public class TeachExamServiceImpl extends ServiceImpl<TeachExamMapper, TeachExam> implements ITeachExamService {

    @Override
    public IPage<TeachExam> pageForTeachExam(Page<TeachExam> page, Map<String, Object> param) {
        return this.baseMapper.pageForTeachExam(page,param);
    }
}
