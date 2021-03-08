package cn.teach.mall.controller;

import cn.teach.mall.service.IRoleMenuService;
import cn.teach.mall.service.IRoleService;
import cn.teach.pojo.mall.entity.Role;
import cn.teach.pojo.mall.entity.RoleMenu;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: ModelViewController
 * @Description: 视图控制器
 * @Author: MaZhuli
 * @Date: 2019/8/14 10:14
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/modelView")
public class ModelViewController {
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private IRoleMenuService iRoleMenuService;

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/16
     * @Description: 编辑页面
     */
    @RequestMapping("/{module}/{page}/{id}")
    public ModelAndView edit(@PathVariable("module") String module,
                             @PathVariable("page") String page,
                             @PathVariable(value = "id", required = true) Integer id) {
        Map map = new HashMap<>();
        map.put("id", id);
        return new ModelAndView(module + "/" + page, map);
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/16
     * @Description: 列表页
     */
    @RequestMapping("/{module}/{page}")
    public ModelAndView frame(@PathVariable("module") String module,
                              @PathVariable("page") String page) {
        return new ModelAndView(module + "/" + page);
    }

    @RequestMapping("/system/authoritySetting/{id}")
    public ModelAndView basicSetEdit(@PathVariable(value = "id", required = true) Integer id, Model model) {
        //管理员
        Role role = iRoleService.getById(id);
        QueryWrapper<RoleMenu> managerMenuQueryWrapper = new QueryWrapper<>();
        managerMenuQueryWrapper.eq("role_id", role.getId());
        List<RoleMenu> managerMenuList = iRoleMenuService.list(managerMenuQueryWrapper);
        //菜单id集合
        List<Integer> menuIdList = managerMenuList.stream().map(m -> m.getMenuId()).collect(Collectors.toList());
        model.addAttribute("manager", role);
        model.addAttribute("menuIdList", menuIdList);
        return new ModelAndView("system/authoritySetting");
    }

}
