package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.ITeachExamService;
import cn.teach.pojo.mall.entity.TeachExam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

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
    public ResultData page(@RequestParam Map<String, Object> param) {
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
}

