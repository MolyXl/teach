package cn.teach.mall.service.impl;

import cn.teach.common.mvc.Page;
import cn.teach.mall.mapper.ForeignWorkMapper;
import cn.teach.mall.service.IForeignWorkService;
import cn.teach.pojo.mall.entity.ForeignWork;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 外聘工作量汇总表 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@Service
public class ForeignWorkServiceImpl extends ServiceImpl<ForeignWorkMapper, ForeignWork> implements IForeignWorkService {

    @Override
    public IPage<ForeignWork> pageForForeignWork(Page<ForeignWork> page, Map<String, Object> param) {
        return this.baseMapper.pageForForeignWork(page,param);
    }
}
