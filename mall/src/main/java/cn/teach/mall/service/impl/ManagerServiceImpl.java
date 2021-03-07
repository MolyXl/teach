package cn.teach.mall.service.impl;

import cn.teach.common.mvc.Page;
import cn.teach.mall.mapper.ManagerMapper;
import cn.teach.mall.service.IManagerService;
import cn.teach.pojo.mall.entity.Manager;
import cn.teach.pojo.mall.vo.ManagerVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 后台管理员 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2019-07-31
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {

    @Override
    public IPage<ManagerVo> pageForManagerVo(Page<ManagerVo> page, Map<String, Object> param) {
        return this.baseMapper.pageForManagerVo(page,param);
    }
}
