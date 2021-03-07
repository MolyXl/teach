package cn.teach.mall.mapper;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.Role;
import cn.teach.pojo.mall.vo.RoleVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Map;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author MaZhuli
 * @since 2019-07-31
 */
public interface RoleMapper extends BaseMapper<Role> {

    IPage<RoleVo> pageForRoleVo(Page<RoleVo> page, Map<String, Object> param);
}
