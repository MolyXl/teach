package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.ExcelUtil_JXL;
import cn.teach.common.util.JsonUtils;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.ITeachCourseService;
import cn.teach.pojo.mall.entity.TeachCourse;
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
 * 课堂教学及评卷业绩点统计表 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/teachCourse")
public class TeachCourseController {


    @Autowired
    private ITeachCourseService iTeachCourseService;

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
        Page<TeachCourse> page = PageHelperUtil.getPageInfo(param);
        IPage<TeachCourse> pageList = iTeachCourseService.pageForTeachCourse(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 查看详情
     */
    @RequestMapping("/get")
    public ResponseEntity<TeachCourse> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iTeachCourseService.getById(id));
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 添加/修改
     */
    @RequestMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(TeachCourse teachCourse, HttpSession session) {
        if (teachCourse.getId() != null && teachCourse.getId() > 0) {
            if (teachCourse.getStatus() == 1) {
                teachCourse.setCommitTime(new Date());
            } else if (teachCourse.getStatus() == 2 || teachCourse.getStatus() == 3) {
                teachCourse.setAuditTime(new Date());
                teachCourse.setManagerId((Integer) session.getAttribute("managerId"));
            }
            return ResponseHelper.returnResponse(iTeachCourseService.updateById(teachCourse));
        } else {
            teachCourse.setCreateTime(new Date());
            teachCourse.setStatus(0);
            teachCourse.setJobNo(session.getAttribute("jobNo").toString());
            teachCourse.setTeacherId((Integer) session.getAttribute("managerId"));
            teachCourse.setTeacherName(session.getAttribute("managerName").toString());
            return ResponseHelper.returnResponse(iTeachCourseService.save(teachCourse));
        }
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity<TeachCourse> deleteByid(Integer id) {
        return ResponseHelper.returnResponse(iTeachCourseService.removeById(id));
    }


    /**
     * @Author: MaZhuli
     * @Date: 2021/3/8
     * @Description: 导出
     */
    @RequestMapping(value = "/export")
    public void export(@RequestParam Map<String, Object> param, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        QueryWrapper<TeachCourse> queryWrapper = new QueryWrapper();

        String roleId = session.getAttribute("roleId").toString();
        String managerId = session.getAttribute("managerId").toString();
        if (Integer.parseInt(roleId) != 1) {
            param.put("teacherId", managerId);
            queryWrapper.eq("teacher_id", managerId);
        }
        queryWrapper.eq("status", 2);
        List<TeachCourse> list = iTeachCourseService.list(queryWrapper);
        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList = JsonUtils.readValue(JsonUtils.toJSon(list), mapList.getClass());
        Map<String, Object> headermap = new LinkedHashMap<>();
        headermap.put("工号", "jobNo");
        headermap.put("教师姓名", "teacherName");
        headermap.put("课程名称", "courseName");
        headermap.put("上课班级", "className");
        headermap.put("类别", "type");
        headermap.put("课程类型", "courseType");
        headermap.put("特殊课程", "specialCourse");
        headermap.put("周学时数", "weekHour");
        headermap.put("上课周数", "weeks");
        headermap.put("原始总课时数", "originalClassHour");
        headermap.put("分班系数", "classCoefficient");
        headermap.put("课程系数", "courseCoefficient");
        headermap.put("教学结果系数", "teachResultCoefficient");
        headermap.put("考核类型", "inspectType");
        headermap.put("考核类型系数", "inspectTypeCoefficient");
        headermap.put("评卷业绩点", "markExamPoint");
        ExcelUtil_JXL.exportExcel("课堂教学及评卷业绩点统计表.xls", "sheet1", headermap, mapList, response, request);
    }

}

