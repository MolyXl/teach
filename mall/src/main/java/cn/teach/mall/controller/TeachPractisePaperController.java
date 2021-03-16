package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.ExcelUtil_JXL;
import cn.teach.common.util.JsonUtils;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.ITeachPractisePaperService;
import cn.teach.pojo.mall.entity.TeachPractisePaper;
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
 * 实践环节毕业论文、学年论文、创新创业训练计划项目等业绩点统计表 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/teachPractisePaper")
public class TeachPractisePaperController {

    @Autowired
    private ITeachPractisePaperService iTeachPractisePaperService;

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
        Page<TeachPractisePaper> page = PageHelperUtil.getPageInfo(param);
        IPage<TeachPractisePaper> pageList = iTeachPractisePaperService.pageForTeachPractisePaper(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 查看详情
     */
    @RequestMapping("/get")
    public ResponseEntity<TeachPractisePaper> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iTeachPractisePaperService.getById(id));
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 添加/修改
     */
    @RequestMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(TeachPractisePaper teachPractisePaper, HttpSession session) {
        if (teachPractisePaper.getId() != null && teachPractisePaper.getId() > 0) {
            if (teachPractisePaper.getStatus() == 1) {
                teachPractisePaper.setCommitTime(new Date());
            } else if (teachPractisePaper.getStatus() == 2 || teachPractisePaper.getStatus() == 3) {
                teachPractisePaper.setAuditTime(new Date());
                teachPractisePaper.setManagerId((Integer) session.getAttribute("managerId"));
            }
            return ResponseHelper.returnResponse(iTeachPractisePaperService.updateById(teachPractisePaper));
        } else {
            teachPractisePaper.setCreateTime(new Date());
            teachPractisePaper.setStatus(0);
            teachPractisePaper.setJobNo(session.getAttribute("jobNo").toString());
            teachPractisePaper.setTeacherId((Integer) session.getAttribute("managerId"));
            teachPractisePaper.setTeacherName(session.getAttribute("managerName").toString());
            return ResponseHelper.returnResponse(iTeachPractisePaperService.save(teachPractisePaper));
        }
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity<TeachPractisePaper> deleteByid(Integer id) {
        return ResponseHelper.returnResponse(iTeachPractisePaperService.removeById(id));
    }

    /**
     * @Author: MaZhuli
     * @Date: 2021/3/8
     * @Description: 导出
     */
    @RequestMapping(value = "/export")
    public void export(@RequestParam Map<String, Object> param, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        QueryWrapper<TeachPractisePaper> queryWrapper = new QueryWrapper();

        String roleId = session.getAttribute("roleId").toString();
        String managerId = session.getAttribute("managerId").toString();
        if (Integer.parseInt(roleId) != 1) {
            param.put("teacherId", managerId);
            queryWrapper.eq("teacher_id", managerId);
        }
        queryWrapper.eq("status", 2);
        List<TeachPractisePaper> list = iTeachPractisePaperService.list(queryWrapper);
        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList = JsonUtils.readValue(JsonUtils.toJSon(list), mapList.getClass());
        Map<String, Object> headermap = new LinkedHashMap<>();
        headermap.put("工号", "jobNo");
        headermap.put("教师姓名", "teacherName");
        headermap.put("环节类型", "linkType");
        headermap.put("学生对象", "className");
        headermap.put("指导毕业论文人数", "studentAmount");
        headermap.put("毕业设计类型", "designType");
        headermap.put("指导毕业论文业绩点", "paperPoint");
        headermap.put("指导学年论文人数", "paperStudentAmount");
        headermap.put("指导学年论文业绩点", "totalPaperAmount");
        headermap.put("指导创新创业训练级别", "innovativeLevel");
        headermap.put("指导创新创业训练业绩点", "innovativePoint");
        ExcelUtil_JXL.exportExcel("实践环节毕业论文、学年论文、创新创业训练计划项目等业绩点统计表.xls", "sheet1", headermap, mapList, response, request);
    }
}

