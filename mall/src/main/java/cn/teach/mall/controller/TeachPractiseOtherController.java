package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.ExcelUtil_JXL;
import cn.teach.common.util.JsonUtils;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.ITeachPractiseOtherService;
import cn.teach.pojo.mall.entity.TeachPractiseOther;
import cn.teach.pojo.mall.entity.TeachPractisePaper;
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
@RequestMapping("/teachPractiseOther")
public class TeachPractiseOtherController {

    @Autowired
    private ITeachPractiseOtherService iTeachPractiseOtherService;

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
        Page<TeachPractiseOther> page = PageHelperUtil.getPageInfo(param);
        IPage<TeachPractiseOther> pageList = iTeachPractiseOtherService.pageForTeachPractiseOther(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 查看详情
     */
    @RequestMapping("/get")
    public ResponseEntity<TeachPractiseOther> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iTeachPractiseOtherService.getById(id));
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 添加/修改
     */
    @RequestMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(TeachPractiseOther teachPractiseOther, HttpSession session) {
        if (teachPractiseOther.getId() != null && teachPractiseOther.getId() > 0) {
            if (teachPractiseOther.getStatus() == 1) {
                teachPractiseOther.setCommitTime(new Date());
            } else if (teachPractiseOther.getStatus() == 2 || teachPractiseOther.getStatus() == 3) {
                teachPractiseOther.setAuditTime(new Date());
                teachPractiseOther.setManagerId((Integer) session.getAttribute("managerId"));
            }
            return ResponseHelper.returnResponse(iTeachPractiseOtherService.updateById(teachPractiseOther));
        } else {
            teachPractiseOther.setCreateTime(new Date());
            teachPractiseOther.setStatus(0);
            teachPractiseOther.setJobNo(session.getAttribute("jobNo").toString());
            teachPractiseOther.setTeacherId((Integer) session.getAttribute("managerId"));
            teachPractiseOther.setTeacherName(session.getAttribute("managerName").toString());
            return ResponseHelper.returnResponse(iTeachPractiseOtherService.save(teachPractiseOther));
        }
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity<TeachPractiseOther> deleteByid(Integer id) {
        return ResponseHelper.returnResponse(iTeachPractiseOtherService.removeById(id));
    }

    /**
     * @Author: MaZhuli
     * @Date: 2021/3/8
     * @Description: 导出
     */
    @RequestMapping(value = "/export")
    public void export(@RequestParam Map<String, Object> param, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        QueryWrapper<TeachPractiseOther> queryWrapper = new QueryWrapper();

        String roleId = session.getAttribute("roleId").toString();
        String managerId = session.getAttribute("managerId").toString();
        if (Integer.parseInt(roleId) != 1) {
            param.put("teacherId", managerId);
            queryWrapper.eq("teacher_id", managerId);
        }
        queryWrapper.eq("status", 2);
        List<TeachPractiseOther> list = iTeachPractiseOtherService.list(queryWrapper);
        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList = JsonUtils.readValue(JsonUtils.toJSon(list), mapList.getClass());
        Map<String, Object> headermap = new LinkedHashMap<>();
        headermap.put("工号", "jobNo");
        headermap.put("教师姓名", "teacherName");
        headermap.put("上半年指导毕业论文业绩点", "firstGraduationPoint");
        headermap.put("上半年指导学年论文业绩点", "firstYearPoint");
        headermap.put("上半年指导创新创业训练业绩点", "firstRevolutionPoint");
        headermap.put("上半年课程设计/项目课程业绩点", "firstCoursePoint");
        headermap.put("上半年实践环节业绩点合计", "firstPractisePoint");
        headermap.put("下半年指导毕业论文业绩点", "secondGraduationPoint");
        headermap.put("下半年指导学年论文业绩点", "secondYearPoint");
        headermap.put("下半年指导创新创业训练业绩点", "secondRevolutionPoint");
        headermap.put("下半年课程设计/项目课程业绩点", "secondCoursePoint");
        headermap.put("下半年实践环节业绩点合计", "secondPractisePoint");
        headermap.put("全年合计", "totalPoint");
        ExcelUtil_JXL.exportExcel("实践环节专业学科竞赛业绩点统计表.xls", "sheet1", headermap, mapList, response, request);
    }
}

