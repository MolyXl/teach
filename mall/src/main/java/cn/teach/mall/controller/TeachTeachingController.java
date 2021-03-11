package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.ITeachCourseService;
import cn.teach.mall.service.ITeachTeachingService;
import cn.teach.pojo.mall.entity.Role;
import cn.teach.pojo.mall.entity.TeachTeaching;
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
    public ResultData page(@RequestParam Map<String, Object> param) {
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
    @RequestMapping("/get")
    public ResponseEntity<TeachTeaching> delete(Integer id) {
        return ResponseHelper.returnResponse(iTeachTeachingService.removeById(id));
    }
}

