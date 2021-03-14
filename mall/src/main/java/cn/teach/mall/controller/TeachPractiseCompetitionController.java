package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.ITeachPractiseCompetitionService;
import cn.teach.pojo.mall.entity.TeachPractiseCompetition;
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
 * 实践环节专业学科竞赛业绩点统计表 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/teachPractiseCompetition")
public class TeachPractiseCompetitionController {
    @Autowired
    private ITeachPractiseCompetitionService iTeachPractiseCompetitionService;

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 分页
     */
    @RequestMapping(value = "/page")
    public ResultData page(@RequestParam Map<String, Object> param) {
        Page<TeachPractiseCompetition> page = PageHelperUtil.getPageInfo(param);
        IPage<TeachPractiseCompetition> pageList = iTeachPractiseCompetitionService.pageForTeachPractiseCompetition(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 查看详情
     */
    @RequestMapping("/get")
    public ResponseEntity<TeachPractiseCompetition> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iTeachPractiseCompetitionService.getById(id));
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 添加/修改
     */
    @RequestMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(TeachPractiseCompetition teachPractiseCompetition, HttpSession session) {
        if (teachPractiseCompetition.getId() != null && teachPractiseCompetition.getId() > 0) {
            if (teachPractiseCompetition.getStatus() == 1) {
                teachPractiseCompetition.setCommitTime(new Date());
            } else if (teachPractiseCompetition.getStatus() == 2 || teachPractiseCompetition.getStatus() == 3) {
                teachPractiseCompetition.setAuditTime(new Date());
                teachPractiseCompetition.setManagerId((Integer) session.getAttribute("managerId"));
            }
            return ResponseHelper.returnResponse(iTeachPractiseCompetitionService.updateById(teachPractiseCompetition));
        } else {
            teachPractiseCompetition.setCreateTime(new Date());
            teachPractiseCompetition.setStatus(0);
            teachPractiseCompetition.setJobNo(session.getAttribute("jobNo").toString());
            teachPractiseCompetition.setTeacherId((Integer) session.getAttribute("managerId"));
            teachPractiseCompetition.setTeacherName(session.getAttribute("managerName").toString());
            return ResponseHelper.returnResponse(iTeachPractiseCompetitionService.save(teachPractiseCompetition));
        }
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity<TeachPractiseCompetition> deleteByid(Integer id) {
        return ResponseHelper.returnResponse(iTeachPractiseCompetitionService.removeById(id));
    }
}

