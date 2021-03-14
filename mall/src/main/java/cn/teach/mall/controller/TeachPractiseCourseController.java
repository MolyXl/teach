package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.ITeachPractiseCourseService;
import cn.teach.pojo.mall.entity.TeachPractiseCourse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 实践环节课程设计/项目课程等业绩点统计表 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/teachPractiseCourse")
public class TeachPractiseCourseController {

    @Autowired
    private ITeachPractiseCourseService iTeachPractiseCourseService;

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
        Page<TeachPractiseCourse> page = PageHelperUtil.getPageInfo(param);
        IPage<TeachPractiseCourse> pageList = iTeachPractiseCourseService.pageForTeachPractiseCourse(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 查看详情
     */
    @RequestMapping("/get")
    public ResponseEntity<TeachPractiseCourse> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iTeachPractiseCourseService.getById(id));
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 添加/修改
     */
    @RequestMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(TeachPractiseCourse teachPractiseCourse, HttpSession session) {
        if (teachPractiseCourse.getId() != null && teachPractiseCourse.getId() > 0) {
            if (teachPractiseCourse.getStatus() == 1) {
                teachPractiseCourse.setCommitTime(new Date());
            } else if (teachPractiseCourse.getStatus() == 2 || teachPractiseCourse.getStatus() == 3) {
                teachPractiseCourse.setAuditTime(new Date());
                teachPractiseCourse.setManagerId((Integer) session.getAttribute("managerId"));
            }
            return ResponseHelper.returnResponse(iTeachPractiseCourseService.updateById(teachPractiseCourse));
        } else {
            teachPractiseCourse.setCreateTime(new Date());
            teachPractiseCourse.setStatus(0);
            teachPractiseCourse.setJobNo(session.getAttribute("jobNo").toString());
            teachPractiseCourse.setTeacherId((Integer) session.getAttribute("managerId"));
            teachPractiseCourse.setTeacherName(session.getAttribute("managerName").toString());
            return ResponseHelper.returnResponse(iTeachPractiseCourseService.save(teachPractiseCourse));
        }
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity<TeachPractiseCourse> deleteByid(Integer id) {
        return ResponseHelper.returnResponse(iTeachPractiseCourseService.removeById(id));
    }
}

