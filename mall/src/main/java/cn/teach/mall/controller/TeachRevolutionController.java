package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.ExcelUtil_JXL;
import cn.teach.common.util.JsonUtils;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.ITeachRevolutionService;
import cn.teach.pojo.mall.entity.TeachRevolution;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * <p>
 * 教学改革增量业绩点统计表 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/teachRevolution")
public class TeachRevolutionController {
    @Autowired
    private ITeachRevolutionService iTeachRevolutionService;

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 分页
     */
    @RequestMapping(value = "/page")
    public ResultData page(@RequestParam Map<String, Object> param, HttpSession session) {
        String roleId = session.getAttribute("roleId").toString();
        String managerId = session.getAttribute("managerId").toString();
        if (Integer.parseInt(roleId) != 1) {
            param.put("teacherId", managerId);
        }
        Page<TeachRevolution> page = PageHelperUtil.getPageInfo(param);
        IPage<TeachRevolution> pageList = iTeachRevolutionService.pageForTeachRevolution(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 查看详情
     */
    @RequestMapping("/get")
    public ResponseEntity<TeachRevolution> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iTeachRevolutionService.getById(id));
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 添加/修改
     */
    @RequestMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(TeachRevolution teachRevolution, HttpSession session) {
        if (teachRevolution.getId() != null && teachRevolution.getId() > 0) {
            if (teachRevolution.getStatus() == 1) {
                teachRevolution.setCommitTime(new Date());
            } else if (teachRevolution.getStatus() == 2 || teachRevolution.getStatus() == 3) {
                teachRevolution.setAuditTime(new Date());
                teachRevolution.setManagerId((Integer) session.getAttribute("managerId"));
            }
            return ResponseHelper.returnResponse(iTeachRevolutionService.updateById(teachRevolution));
        } else {
            teachRevolution.setCreateTime(new Date());
            teachRevolution.setStatus(0);
            teachRevolution.setTeacherId((Integer) session.getAttribute("managerId"));
            return ResponseHelper.returnResponse(iTeachRevolutionService.save(teachRevolution));
        }
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity<TeachRevolution> deleteByid(Integer id) {
        return ResponseHelper.returnResponse(iTeachRevolutionService.removeById(id));
    }

    /**
     * @Author: MaZhuli
     * @Date: 2021/3/8
     * @Description: 导出
     */
    @RequestMapping(value = "/export")
    public void export(@RequestParam Map<String, Object> param, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        QueryWrapper<TeachRevolution> queryWrapper = new QueryWrapper();

        String roleId = session.getAttribute("roleId").toString();
        String managerId = session.getAttribute("managerId").toString();
        if (Integer.parseInt(roleId) != 1) {
            param.put("teacherId", managerId);
            queryWrapper.eq("teacher_id", managerId);
        }
        queryWrapper.eq("status", 2);
        List<TeachRevolution> list = iTeachRevolutionService.list(queryWrapper);
        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList = JsonUtils.readValue(JsonUtils.toJSon(list), mapList.getClass());
        Map<String, Object> headermap = new LinkedHashMap<>();
        headermap.put("类型", "type");
        headermap.put("本科教学工程类别", "course");
        headermap.put("级别", "level");
        headermap.put("项目名称", "projectName");
        headermap.put("立项年月", "approvalDate");
        headermap.put("建设周期", "buildPeriod");
        headermap.put("年度建设任务完成情况", "yearFinishStatus");
        headermap.put("项目建设情况", "projectBuildStatus");
        headermap.put("项目负责人", "chargeMan");
        headermap.put("当年业绩点", "yearPoint");
        headermap.put("本项目总业绩点", "projectPoint");
        ExcelUtil_JXL.exportExcel("教学改革增量业绩点统计表.xls", "sheet1", headermap, mapList, response, request);
    }
}

