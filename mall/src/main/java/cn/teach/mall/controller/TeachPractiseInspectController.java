package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.ITeachPractiseInspectService;
import cn.teach.pojo.mall.entity.TeachPractiseInspect;
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
 * 实践环节专业学科竞赛业绩点统计表 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/teachPractiseInspect")
public class TeachPractiseInspectController {

    @Autowired
    private ITeachPractiseInspectService iTeachPractiseInspectService;

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 分页
     */
    @RequestMapping(value = "/page")
    public ResultData page(@RequestParam Map<String, Object> param) {
        Page<TeachPractiseInspect> page = PageHelperUtil.getPageInfo(param);
        IPage<TeachPractiseInspect> pageList = iTeachPractiseInspectService.pageForTeachPractiseInspect(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 查看详情
     */
    @RequestMapping("/get")
    public ResponseEntity<TeachPractiseInspect> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iTeachPractiseInspectService.getById(id));
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 添加/修改
     */
    @RequestMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(TeachPractiseInspect teachPractiseInspect, HttpSession session) {
        if (teachPractiseInspect.getId() != null && teachPractiseInspect.getId() > 0) {
            if (teachPractiseInspect.getStatus() == 1) {
                teachPractiseInspect.setCommitTime(new Date());
            } else if (teachPractiseInspect.getStatus() == 2 || teachPractiseInspect.getStatus() == 3) {
                teachPractiseInspect.setAuditTime(new Date());
                teachPractiseInspect.setManagerId((Integer) session.getAttribute("managerId"));
            }
            return ResponseHelper.returnResponse(iTeachPractiseInspectService.updateById(teachPractiseInspect));
        } else {
            teachPractiseInspect.setCreateTime(new Date());
            teachPractiseInspect.setStatus(0);
            teachPractiseInspect.setJobNo(session.getAttribute("jobNo").toString());
            teachPractiseInspect.setTeacherId((Integer) session.getAttribute("managerId"));
            teachPractiseInspect.setTeacherName(session.getAttribute("managerName").toString());
            return ResponseHelper.returnResponse(iTeachPractiseInspectService.save(teachPractiseInspect));
        }
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity<TeachPractiseInspect> deleteByid(Integer id) {
        return ResponseHelper.returnResponse(iTeachPractiseInspectService.removeById(id));
    }
}

