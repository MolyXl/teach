package cn.teach.mall.service.impl;

import cn.teach.common.mvc.Page;
import cn.teach.mall.mapper.ForeignPractiseMapper;
import cn.teach.mall.service.IForeignPractiseService;
import cn.teach.pojo.mall.entity.ForeignPractise;
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
public class ForeignPractiseServiceImpl extends ServiceImpl<ForeignPractiseMapper, ForeignPractise> implements IForeignPractiseService {

    @Override
    public IPage<ForeignPractise> pageForForeignPractise(Page<ForeignPractise> page, Map<String, Object> param) {
        return this.baseMapper.pageForForeignPractise(page,param);
    }
}
