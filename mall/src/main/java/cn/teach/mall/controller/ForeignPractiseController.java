package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.ExcelUtil_JXL;
import cn.teach.common.util.JsonUtils;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.IForeignPractiseService;
import cn.teach.pojo.mall.entity.ForeignPractise;
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
 * 外聘工作量汇总表 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/foreignPractise")
public class ForeignPractiseController {

    @Autowired
    private IForeignPractiseService iForeignPractiseService;

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
        Page<ForeignPractise> page = PageHelperUtil.getPageInfo(param);
        IPage<ForeignPractise> pageList = iForeignPractiseService.pageForForeignPractise(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 查看详情
     */
    @RequestMapping("/get")
    public ResponseEntity<ForeignPractise> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iForeignPractiseService.getById(id));
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 添加/修改
     */
    @RequestMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(ForeignPractise foreignPractise, HttpSession session) {
        if (foreignPractise.getId() != null && foreignPractise.getId() > 0) {
            if (foreignPractise.getStatus() == 1) {
                foreignPractise.setCommitTime(new Date());
            } else if (foreignPractise.getStatus() == 2 || foreignPractise.getStatus() == 3) {
                foreignPractise.setAuditTime(new Date());
                foreignPractise.setManagerId((Integer) session.getAttribute("managerId"));
            }
            return ResponseHelper.returnResponse(iForeignPractiseService.updateById(foreignPractise));
        } else {
            foreignPractise.setCreateTime(new Date());
            foreignPractise.setStatus(0);
            foreignPractise.setJobNo(session.getAttribute("jobNo").toString());
            foreignPractise.setTeacherId((Integer) session.getAttribute("managerId"));
            foreignPractise.setTeacherName(session.getAttribute("managerName").toString());
            return ResponseHelper.returnResponse(iForeignPractiseService.save(foreignPractise));
        }
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity<ForeignPractise> deleteByid(Integer id) {
        return ResponseHelper.returnResponse(iForeignPractiseService.removeById(id));
    }

    /**
     * @Author: MaZhuli
     * @Date: 2021/3/8
     * @Description: 导出
     */
    @RequestMapping(value = "/export")
    public void export(@RequestParam Map<String, Object> param, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        QueryWrapper<ForeignPractise> queryWrapper = new QueryWrapper();

        String roleId = session.getAttribute("roleId").toString();
        String managerId = session.getAttribute("managerId").toString();
        if (Integer.parseInt(roleId) != 1) {
            param.put("teacherId", managerId);
            queryWrapper.eq("teacher_id", managerId);
        }
        queryWrapper.eq("status", 2);
        List<ForeignPractise> list = iForeignPractiseService.list(queryWrapper);
        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList = JsonUtils.readValue(JsonUtils.toJSon(list), mapList.getClass());
        Map<String, Object> headermap = new LinkedHashMap<>();
        headermap.put("工号", "jobNo");
        headermap.put("教师姓名", "teacherName");
        headermap.put("职称", "position");
        headermap.put("学历", "education");
        headermap.put("单位", "unit");
        headermap.put("主要课程", "course");
        headermap.put("主要班级", "className");
        headermap.put("总人数", "studentAmount");
        headermap.put("开课地点", "place");
        headermap.put("教学形式", "teachType");
        headermap.put("周学时数", "weekHour");
        headermap.put("上课周数", "weeks");
        headermap.put("开始日期", "startDate");
        headermap.put("结束日期", "endDate");
        headermap.put("总课时", "classHour");
        headermap.put("考核方式", "inspectType");
        headermap.put("成果形式", "resultType");
        headermap.put("单课时费用", "price");
        headermap.put("总费用", "totalPrice");
        headermap.put("备注", "remark");
        ExcelUtil_JXL.exportExcel("外聘课程实践工作量统计表.xls", "sheet1", headermap, mapList, response, request);
    }
}

