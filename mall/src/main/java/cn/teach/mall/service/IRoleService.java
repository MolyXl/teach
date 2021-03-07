package cn.teach.mall.service;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.Role;
import cn.teach.pojo.mall.vo.RoleVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author MaZhuli
 * @since 2019-07-31
 */
public interface IRoleService extends IService<Role> {

    IPage<RoleVo> pageForRoleVo(Page<RoleVo> page, Map<String, Object> param);
}
