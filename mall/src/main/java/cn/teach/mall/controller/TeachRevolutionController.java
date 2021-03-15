package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.ITeachRevolutionService;
import cn.teach.pojo.mall.entity.TeachRevolution;
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
 * 教学改革增量业绩点统计表 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/teachRevolution")
public class TeachRevolutionController {
    @Autowired
    private ITeachRevolutionService iTeachRevolutionService;

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
        Page<TeachRevolution> page = PageHelperUtil.getPageInfo(param);
        IPage<TeachRevolution> pageList = iTeachRevolutionService.pageForTeachRevolution(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 查看详情
     */
    @RequestMapping("/get")
    public ResponseEntity<TeachRevolution> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iTeachRevolutionService.getById(id));
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 添加/修改
     */
    @RequestMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(TeachRevolution teachRevolution, HttpSession session) {
        if (teachRevolution.getId() != null && teachRevolution.getId() > 0) {
            if (teachRevolution.getStatus() == 1) {
                teachRevolution.setCommitTime(new Date());
            } else if (teachRevolution.getStatus() == 2 || teachRevolution.getStatus() == 3) {
                teachRevolution.setAuditTime(new Date());
                teachRevolution.setManagerId((Integer) session.getAttribute("managerId"));
            }
            return ResponseHelper.returnResponse(iTeachRevolutionService.updateById(teachRevolution));
        } else {
            teachRevolution.setCreateTime(new Date());
            teachRevolution.setStatus(0);
            teachRevolution.setTeacherId((Integer) session.getAttribute("managerId"));
            return ResponseHelper.returnResponse(iTeachRevolutionService.save(teachRevolution));
        }
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity<TeachRevolution> deleteByid(Integer id) {
        return ResponseHelper.returnResponse(iTeachRevolutionService.removeById(id));
    }
}

