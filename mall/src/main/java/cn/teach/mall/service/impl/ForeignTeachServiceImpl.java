package cn.teach.mall.service.impl;

import cn.teach.common.mvc.Page;
import cn.teach.mall.mapper.ForeignTeachMapper;
import cn.teach.mall.service.IForeignTeachService;
import cn.teach.pojo.mall.entity.ForeignTeach;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 外聘教师教学工作量统计表 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@Service
public class ForeignTeachServiceImpl extends ServiceImpl<ForeignTeachMapper, ForeignTeach> implements IForeignTeachService {

    @Override
    public IPage<ForeignTeach> pageForForeignTeach(Page<ForeignTeach> page, Map<String, Object> param) {
        return this.baseMapper.pageForForeignTeach(page,param);
    }
}
