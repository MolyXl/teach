package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.ExcelUtil_JXL;
import cn.teach.common.util.JsonUtils;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.ITeachPractiseInspectService;
import cn.teach.pojo.mall.entity.TeachPractiseInspect;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * <p>
 * 实践环节专业学科竞赛业绩点统计表 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/teachPractiseInspect")
public class TeachPractiseInspectController {

    @Autowired
    private ITeachPractiseInspectService iTeachPractiseInspectService;

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
        Page<TeachPractiseInspect> page = PageHelperUtil.getPageInfo(param);
        IPage<TeachPractiseInspect> pageList = iTeachPractiseInspectService.pageForTeachPractiseInspect(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 查看详情
     */
    @RequestMapping("/get")
    public ResponseEntity<TeachPractiseInspect> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iTeachPractiseInspectService.getById(id));
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 添加/修改
     */
    @RequestMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(TeachPractiseInspect teachPractiseInspect, HttpSession session) {
        if (teachPractiseInspect.getId() != null && teachPractiseInspect.getId() > 0) {
            if (teachPractiseInspect.getStatus() == 1) {
                teachPractiseInspect.setCommitTime(new Date());
            } else if (teachPractiseInspect.getStatus() == 2 || teachPractiseInspect.getStatus() == 3) {
                teachPractiseInspect.setAuditTime(new Date());
                teachPractiseInspect.setManagerId((Integer) session.getAttribute("managerId"));
            }
            return ResponseHelper.returnResponse(iTeachPractiseInspectService.updateById(teachPractiseInspect));
        } else {
            teachPractiseInspect.setCreateTime(new Date());
            teachPractiseInspect.setStatus(0);
            teachPractiseInspect.setJobNo(session.getAttribute("jobNo").toString());
            teachPractiseInspect.setTeacherId((Integer) session.getAttribute("managerId"));
            teachPractiseInspect.setTeacherName(session.getAttribute("managerName").toString());
            return ResponseHelper.returnResponse(iTeachPractiseInspectService.save(teachPractiseInspect));
        }
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity<TeachPractiseInspect> deleteByid(Integer id) {
        return ResponseHelper.returnResponse(iTeachPractiseInspectService.removeById(id));
    }

    /**
     * @Author: MaZhuli
     * @Date: 2021/3/8
     * @Description: 导出
     */
    @RequestMapping(value = "/export")
    public void export(@RequestParam Map<String, Object> param, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        QueryWrapper<TeachPractiseInspect> queryWrapper = new QueryWrapper();

        String roleId = session.getAttribute("roleId").toString();
        String managerId = session.getAttribute("managerId").toString();
        if (Integer.parseInt(roleId) != 1) {
            param.put("teacherId", managerId);
            queryWrapper.eq("teacher_id", managerId);
        }
        queryWrapper.eq("status", 2);
        List<TeachPractiseInspect> list = iTeachPractiseInspectService.list(queryWrapper);
        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList = JsonUtils.readValue(JsonUtils.toJSon(list), mapList.getClass());
        Map<String, Object> headermap = new LinkedHashMap<>();
        headermap.put("工号", "jobNo");
        headermap.put("教师姓名", "teacherName");
        headermap.put("实习/见习/考察等名称", "name");
        headermap.put("学分", "score");
        headermap.put("实习学生对象", "className");
        headermap.put("指导实习/见习/考察等人数", "student");
        headermap.put("实习/见习/考察/写生等系数", "coefficient");
        headermap.put("指导实习/见习/考察/写生等业绩点", "point");
        ExcelUtil_JXL.exportExcel("实习见习考察业绩点清单.xls", "sheet1", headermap, mapList, response, request);
    }
}

