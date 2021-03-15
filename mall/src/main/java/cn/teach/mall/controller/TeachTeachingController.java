package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.ExcelUtil_JXL;
import cn.teach.common.util.JsonUtils;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.ITeachCourseService;
import cn.teach.mall.service.ITeachTeachingService;
import cn.teach.pojo.mall.entity.Role;
import cn.teach.pojo.mall.entity.TeachTeaching;
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
 * 教师教学工作量汇总表 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/teachTeaching")
public class TeachTeachingController {
    @Autowired
    private ITeachTeachingService iTeachTeachingService;

    /**
     * @Author: MaZhuli
     * @Date: 2021/3/8
     * @Description: 分页
     */
    @RequestMapping(value = "/page")
    public ResultData page(@RequestParam Map<String, Object> param, HttpSession session) {
        String roleId = session.getAttribute("roleId").toString();
        String managerId = session.getAttribute("managerId").toString();
        if (Integer.parseInt(roleId) != 1) {
            param.put("teacherId", managerId);
        }
        Page<TeachTeaching> page = PageHelperUtil.getPageInfo(param);
        IPage<TeachTeaching> pageList = iTeachTeachingService.pageForTeachTeaching(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: MaZhuli
     * @Date: 2021/3/8
     * @Description: 查看详情
     */
    @RequestMapping("/get")
    public ResponseEntity<TeachTeaching> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iTeachTeachingService.getById(id));
    }

    /**
     * @Author: MaZhuli
     * @Date: 2021/3/8
     * @Description: 添加/修改
     */
    @RequestMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(TeachTeaching teachTeaching, HttpSession session) {
        if (teachTeaching.getId() != null && teachTeaching.getId() != -1) {
            if (teachTeaching.getStatus() == 1) {
                teachTeaching.setCommitTime(new Date());
            } else if (teachTeaching.getStatus() == 2 || teachTeaching.getStatus() == 3) {
                teachTeaching.setAuditTime(new Date());
                teachTeaching.setManagerId((Integer) session.getAttribute("managerId"));
            }
            return ResponseHelper.returnResponse(iTeachTeachingService.updateById(teachTeaching));
        } else {
            teachTeaching.setId(null);
            teachTeaching.setCreateTime(new Date());
            teachTeaching.setStatus(0);
            teachTeaching.setJobNo(session.getAttribute("jobNo").toString());
            teachTeaching.setTeacherId((Integer) session.getAttribute("managerId"));
            teachTeaching.setTeacherName(session.getAttribute("managerName").toString());
            return ResponseHelper.returnResponse(iTeachTeachingService.save(teachTeaching));
        }
    }

    /**
     * @Author: MaZhuli
     * @Date: 2021/3/8
     * @Description: 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity<TeachTeaching> delete(Integer id) {
        return ResponseHelper.returnResponse(iTeachTeachingService.removeById(id));
    }

    /**
     * @Author: MaZhuli
     * @Date: 2021/3/8
     * @Description: 分页
     */
    @RequestMapping(value = "/export")
    public void export(@RequestParam Map<String, Object> param, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        QueryWrapper<TeachTeaching> queryWrapper = new QueryWrapper();

        String roleId = session.getAttribute("roleId").toString();
        String managerId = session.getAttribute("managerId").toString();
        if (Integer.parseInt(roleId) != 1) {
            param.put("teacherId", managerId);
            queryWrapper.eq("teacher_id", managerId);
        }
        queryWrapper.eq("status", 2);
        List<TeachTeaching> list = iTeachTeachingService.list(queryWrapper);
        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList = JsonUtils.readValue(JsonUtils.toJSon(list), mapList.getClass());
        Map<String, Object> headermap = new LinkedHashMap<>();
        headermap.put("工号", "jobNo");
        headermap.put("教师姓名", "teacherName");
        headermap.put("上半年课堂教学业绩点", "firstTeachPoint");
        headermap.put("上半年监考业绩点", "firstInspectPoint");
        headermap.put("上半年实践教学业绩点", "firstOtherPoint");
        headermap.put("上半年合计业绩点", "firstTotalPoint");
        headermap.put("下半年课堂教学业绩点", "secondTeachPoint");
        headermap.put("下半年监考业绩点", "secondInspectPoint");
        headermap.put("下半年实践教学业绩点", "secondOtherPoint");
        headermap.put("下半年合计业绩点", "secondTotalPoint");
        headermap.put("全年合计业绩点", "totalPoint");
        ExcelUtil_JXL.exportExcel("教师教学工作量汇总表.xls", "sheet1", headermap, mapList, response, request);
    }

    public static void main(String[] args) {
        List<TeachTeaching> list = new ArrayList<>();
        TeachTeaching teachTeaching = new TeachTeaching();
        teachTeaching.setJobNo("123");
    }
}

