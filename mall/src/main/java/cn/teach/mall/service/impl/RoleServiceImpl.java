package cn.teach.mall.service.impl;

import cn.teach.common.mvc.Page;
import cn.teach.mall.mapper.RoleMapper;
import cn.teach.mall.service.IRoleService;
import cn.teach.pojo.mall.entity.Role;
import cn.teach.pojo.mall.vo.RoleVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2019-07-31
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public IPage<RoleVo> pageForRoleVo(Page<RoleVo> page, Map<String, Object> param) {
        return this.baseMapper.pageForRoleVo(page,param);
    }
}
