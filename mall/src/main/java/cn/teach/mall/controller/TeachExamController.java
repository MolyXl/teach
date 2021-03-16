package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.ExcelUtil_JXL;
import cn.teach.common.util.JsonUtils;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.ITeachExamService;
import cn.teach.pojo.mall.entity.TeachExam;
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
 * 监考听课业绩点统计表 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/teachExam")
public class TeachExamController {
    @Autowired
    private ITeachExamService iTeachExamService;

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
        Page<TeachExam> page = PageHelperUtil.getPageInfo(param);
        IPage<TeachExam> pageList = iTeachExamService.pageForTeachExam(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 查看详情
     */
    @RequestMapping("/get")
    public ResponseEntity<TeachExam> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iTeachExamService.getById(id));
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 添加/修改
     */
    @RequestMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(TeachExam teachExam, HttpSession session) {
        if (teachExam.getId() != null && teachExam.getId() > 0) {
            if (teachExam.getStatus() == 1) {
                teachExam.setCommitTime(new Date());
            } else if (teachExam.getStatus() == 2 || teachExam.getStatus() == 3) {
                teachExam.setAuditTime(new Date());
                teachExam.setManagerId((Integer) session.getAttribute("managerId"));
            }
            return ResponseHelper.returnResponse(iTeachExamService.updateById(teachExam));
        } else {
            teachExam.setCreateTime(new Date());
            teachExam.setStatus(0);
            teachExam.setJobNo(session.getAttribute("jobNo").toString());
            teachExam.setTeacherId((Integer) session.getAttribute("managerId"));
            teachExam.setTeacherName(session.getAttribute("managerName").toString());
            return ResponseHelper.returnResponse(iTeachExamService.save(teachExam));
        }
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity<TeachExam> deleteByid(Integer id) {
        return ResponseHelper.returnResponse(iTeachExamService.removeById(id));
    }

    /**
     * @Author: MaZhuli
     * @Date: 2021/3/8
     * @Description: 导出
     */
    @RequestMapping(value = "/export")
    public void export(@RequestParam Map<String, Object> param, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        QueryWrapper<TeachExam> queryWrapper = new QueryWrapper();

        String roleId = session.getAttribute("roleId").toString();
        String managerId = session.getAttribute("managerId").toString();
        if (Integer.parseInt(roleId) != 1) {
            param.put("teacherId", managerId);
            queryWrapper.eq("teacher_id", managerId);
        }
        queryWrapper.eq("status", 2);
        List<TeachExam> list = iTeachExamService.list(queryWrapper);
        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList = JsonUtils.readValue(JsonUtils.toJSon(list), mapList.getClass());
        Map<String, Object> headermap = new LinkedHashMap<>();
        headermap.put("工号", "jobNo");
        headermap.put("教师姓名", "teacherName");
        headermap.put("上半年监考场次", "examFirstExamAmount");
        headermap.put("上半年监考业绩点", "examFirstInspectPoint");
        headermap.put("下半年监考场次", "examSecondExamAmount");
        headermap.put("下半年监考业绩点", "examSecondInspectPoint");
        headermap.put("上半年听课场次", "listenFirstListenAmount");
        headermap.put("上半年听课业绩点", "listenFirstListenPoint");
        headermap.put("下半年听课场次", "listenSecondListenAmount");
        headermap.put("下半年听课业绩点", "listenSecondListenPoint");
        ExcelUtil_JXL.exportExcel("监考听课业绩点统计表.xls", "sheet1", headermap, mapList, response, request);
    }
}

