package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.IManagerService;
import cn.teach.mall.service.IMenuService;
import cn.teach.mall.service.IRoleMenuService;
import cn.teach.mall.service.IRoleService;
import cn.teach.pojo.mall.entity.Manager;
import cn.teach.pojo.mall.entity.Menu;
import cn.teach.pojo.mall.entity.Role;
import cn.teach.pojo.mall.entity.RoleMenu;
import cn.teach.pojo.mall.vo.RoleVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2019-07-31
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IManagerService iManagerService;

    @Autowired
    private IRoleMenuService iRoleMenuService;

    @Autowired
    private IMenuService iMenuService;

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/6
     * @Description: 添加管理员
     */
    @RequestMapping("/save")
    public ResponseEntity save(Role role) {
        role.setOperateTime(new Date());
        return ResponseHelper.returnResponse(iRoleService.save(role));
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/8
     * @Description: 删除角色
     */
    @RequestMapping("/delete")
    public ResponseEntity delete(Integer id) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", id);
        int count = iManagerService.count(queryWrapper);
        if (count == 0) {
            return ResponseHelper.returnResponse(iRoleService.removeById(id));
        } else {
            return new ResponseEntity(ResultErrorCode.FAIL, "该角色下仍有管理员");
        }
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/6
     * @Description: 编辑角色
     */
    @RequestMapping("/update")
    public ResponseEntity update(Role role) {
        role.setOperateTime(new Date());
        return ResponseHelper.returnResponse(iRoleService.updateById(role));
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/8
     * @Description: 查看角色详情
     */
    @RequestMapping("/get")
    public ResponseEntity<Role> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iRoleService.getById(id));
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/6
     * @Description: 角色分页
     */
    @RequestMapping(value = "/page")
    public ResultData page(@RequestParam Map<String, Object> param) {
        Page<RoleVo> page = PageHelperUtil.getPageInfo(param);
        IPage<RoleVo> pageList = iRoleService.pageForRoleVo(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/20
     * @Description: 获取角色列表
     */
    @RequestMapping(value = "/getRoleList")
    public ResponseEntity getRoleList() {
        List<Role> list = iRoleService.list();
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", list);
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/8
     * @Description: 获取角色权限列表
     */
    @RequestMapping(value = "/getMenuListForRole")
    public ResponseEntity getMenuListForRole(Integer roleId) {
        QueryWrapper<RoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        List<RoleMenu> list = iRoleMenuService.list(queryWrapper);
        List<Integer> collect = list.stream().map(r -> r.getMenuId()).collect(Collectors.toList());
        QueryWrapper<Menu> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.in("id", collect);
        List<Menu> menuList = iMenuService.list(queryWrapper1);
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", menuList);
    }

    /**
     * @Author: MaZhuli
     * @Description: 修改权限设置
     * @Date 2019/9/10 11:41
     */
    @RequestMapping(value = "/updateAuthority")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity updateAuthority(@RequestBody Map map) {
        Integer id = Integer.parseInt(map.get("id").toString());
        List<String> menuIdList = (List<String>) map.get("menuIdList");
        QueryWrapper<RoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", id);
        iRoleMenuService.remove(queryWrapper);
        QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.in("id", menuIdList);
        List<Menu> menuList = iMenuService.list(menuQueryWrapper);
        Set<String> collect = menuList.stream().map(m -> m.getParentId().toString()).collect(Collectors.toSet());
        menuIdList.addAll(collect);
        List<RoleMenu> managerMenuList = new ArrayList<>();
        for (String menuId : menuIdList) {
            RoleMenu managerMenu = new RoleMenu();
            managerMenu.setMenuId(Integer.parseInt(menuId));
            managerMenu.setRoleId(id);
            managerMenuList.add(managerMenu);
        }
        return ResponseHelper.returnResponse(iRoleMenuService.saveBatch(managerMenuList));
    }
}

