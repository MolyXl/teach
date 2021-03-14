package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.MD5Utils;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.IManagerService;
import cn.teach.mall.service.IMenuService;
import cn.teach.mall.service.IRoleMenuService;
import cn.teach.pojo.mall.bo.ManagerBo;
import cn.teach.pojo.mall.entity.Manager;
import cn.teach.pojo.mall.entity.Menu;
import cn.teach.pojo.mall.entity.RoleMenu;
import cn.teach.pojo.mall.enums.IsOrNotEnums;
import cn.teach.pojo.mall.vo.ManagerVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台管理员 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2019-07-31
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private IManagerService iManagerService;
    @Autowired
    private IRoleMenuService iRoleMenuService;
    @Autowired
    private IMenuService iMenuService;

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/6
     * @Description: 登录
     */
    @RequestMapping("/login")
    public ResponseEntity login(String account, String password, String validate, HttpSession session) {
        /*String validateCode = session.getAttribute("validate").toString();
        if(!validateCode.equalsIgnoreCase(validate)){
            return new ResponseEntity<>(ResultErrorCode.FAIL, "验证码输入错误");
        }*/
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);
        queryWrapper.eq("password", MD5Utils.MD5(password));
        //queryWrapper.eq("status", IsOrNotEnums.NOT.getStatus());
        Manager one = iManagerService.getOne(queryWrapper);
        if (one != null && one.getStatus().equals(IsOrNotEnums.NOT.getStatus())) {
            return new ResponseEntity<>(ResultErrorCode.FAIL, "该账户已被冻结");
        }
        if (one != null) {
            one.setPassword(null);
            Integer roleId = one.getRoleId();
            QueryWrapper<RoleMenu> roleMenuWrapper = new QueryWrapper<>();
            roleMenuWrapper.eq("role_id", roleId);
            List<RoleMenu> list = iRoleMenuService.list(roleMenuWrapper);
            List<Integer> menuIdList = list.stream().map(r -> r.getMenuId()).collect(Collectors.toList());
            QueryWrapper<Menu> menuWrapper = new QueryWrapper<>();
            menuWrapper.in("id", menuIdList == null || menuIdList.size() == 0 ? Arrays.asList(-1) : menuIdList);
            List<Menu> menuList = iMenuService.list(menuWrapper);
            Set<Integer> collect = menuList.stream().map(m -> m.getParentId()).collect(Collectors.toSet());
            QueryWrapper<Menu> parentWrapper = new QueryWrapper<>();
            parentWrapper.in("id", collect == null || collect.size() == 0 ? Arrays.asList(-1) : collect);
            parentWrapper.eq("is_leaf", 0);
            List<Menu> parentMenuList = iMenuService.list(parentWrapper);
            Map<String, Object> result = new HashMap<>();
            result.put("manager", one);
            result.put("parentMenuList", parentMenuList);
            result.put("menuList", menuList);
            session.setAttribute("managerId", one.getId());
            session.setAttribute("managerName", one.getName());
            session.setAttribute("jobNo", one.getJobNo());
            session.setAttribute("roleId", one.getRoleId());
            return new ResponseEntity<>(ResultErrorCode.SUCCESS, "登录成功", result);
        } else {
            return new ResponseEntity<>(ResultErrorCode.FAIL, "账号或密码错误");
        }
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/6
     * @Description: 修改密码
     */
    @RequestMapping("/updatePassword")
    public ResponseEntity updatePassword(String headPortrait, String account, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UpdateWrapper<Manager> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set(!StringUtils.isEmpty(password), "password", MD5Utils.MD5(password));
        updateWrapper.eq("account", account);
        boolean update = iManagerService.update(updateWrapper);
        if (update) {
            session.removeAttribute("manager");
        }
        return ResponseHelper.returnResponse(update);
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/6
     * @Description: 判断用户名是否存在
     */
    @RequestMapping("/isAccountExist")
    public ResponseEntity isAccountExist(String account) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);
        Manager one = iManagerService.getOne(queryWrapper);
        return ResponseHelper.returnResponse(one == null);
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/6
     * @Description: 添加管理员
     */
    @RequestMapping("/save")
    public ResponseEntity save(ManagerBo manager) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", manager.getAccount());
        Manager one = iManagerService.getOne(queryWrapper);
        if (one != null) {
            return new ResponseEntity(ResultErrorCode.FAIL, "该账户已存在");
        }
        manager.setPassword(MD5Utils.MD5(manager.getPassword()));
        return ResponseHelper.returnResponse(iManagerService.save(manager));
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/6
     * @Description: 编辑管理员
     */
    @RequestMapping("/update")
    public ResponseEntity update(ManagerBo manager) {
        if (!StringUtils.isEmpty(manager.getPassword())) {
            manager.setPassword(MD5Utils.MD5(manager.getPassword()));
        } else {
            manager.setPassword(null);
        }
        return ResponseHelper.returnResponse(iManagerService.updateById(manager));
    }

    /**
     * @Author: MaZhuli
     * @Description: 获取管理员信息详情
     * @Date 2019/9/9 17:13
     */
    @RequestMapping("/get")
    public ResponseEntity get(Integer id) {
        Manager manager = iManagerService.getById(id);
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", manager);
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/6
     * @Description: 分页
     */
    @RequestMapping(value = "/page")
    public ResultData page(@RequestParam Map<String, Object> param) {
        Page<ManagerVo> page = PageHelperUtil.getPageInfo(param);
        IPage<ManagerVo> pageList = iManagerService.pageForManagerVo(page, param);
        List<ManagerVo> records = pageList.getRecords();
        records.forEach(m -> m.setStatusStr(m.getStatus().equals(IsOrNotEnums.NOT.getStatus()) ? "已停用" : "已启用"));
        return new ResultData<>(pageList.getTotal(), records);
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/6
     * @Description: 启用/停用
     */
    @RequestMapping("/enableOrDisable")
    public ResponseEntity enableOrDisable(Integer id, Integer status) {
        Manager manager = new Manager();
        manager.setId(id);
        manager.setStatus(status);
        return ResponseHelper.returnResponse(iManagerService.updateById(manager));
    }


}

