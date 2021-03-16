package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.ExcelUtil_JXL;
import cn.teach.common.util.JsonUtils;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.IForeignWorkService;
import cn.teach.pojo.mall.entity.ForeignWork;
import cn.teach.pojo.mall.entity.TeachPractiseCompetition;
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
@RequestMapping("/foreignWork")
public class ForeignWorkController {


    @Autowired
    private IForeignWorkService iForeignWorkService;

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
        Page<ForeignWork> page = PageHelperUtil.getPageInfo(param);
        IPage<ForeignWork> pageList = iForeignWorkService.pageForForeignWork(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 查看详情
     */
    @RequestMapping("/get")
    public ResponseEntity<ForeignWork> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iForeignWorkService.getById(id));
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 添加/修改
     */
    @RequestMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(ForeignWork foreignWork, HttpSession session) {
        if (foreignWork.getId() != null && foreignWork.getId() > 0) {
            if (foreignWork.getStatus() == 1) {
                foreignWork.setCommitTime(new Date());
            } else if (foreignWork.getStatus() == 2 || foreignWork.getStatus() == 3) {
                foreignWork.setAuditTime(new Date());
                foreignWork.setManagerId((Integer) session.getAttribute("managerId"));
            }
            return ResponseHelper.returnResponse(iForeignWorkService.updateById(foreignWork));
        } else {
            foreignWork.setCreateTime(new Date());
            foreignWork.setStatus(0);
            foreignWork.setJobNo(session.getAttribute("jobNo").toString());
            foreignWork.setTeacherId((Integer) session.getAttribute("managerId"));
            foreignWork.setTeacherName(session.getAttribute("managerName").toString());
            return ResponseHelper.returnResponse(iForeignWorkService.save(foreignWork));
        }
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity<ForeignWork> deleteByid(Integer id) {
        return ResponseHelper.returnResponse(iForeignWorkService.removeById(id));
    }

    /**
     * @Author: MaZhuli
     * @Date: 2021/3/8
     * @Description: 导出
     */
    @RequestMapping(value = "/export")
    public void export(@RequestParam Map<String, Object> param, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        QueryWrapper<ForeignWork> queryWrapper = new QueryWrapper();

        String roleId = session.getAttribute("roleId").toString();
        String managerId = session.getAttribute("managerId").toString();
        if (Integer.parseInt(roleId) != 1) {
            param.put("teacherId", managerId);
            queryWrapper.eq("teacher_id", managerId);
        }
        queryWrapper.eq("status", 2);
        List<ForeignWork> list = iForeignWorkService.list(queryWrapper);
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
        headermap.put("总课时", "classHour");
        headermap.put("单课时费用", "price");
        headermap.put("总费用", "totalPrice");
        ExcelUtil_JXL.exportExcel("外聘工作量汇总表.xls", "sheet1", headermap, mapList, response, request);
    }
}

