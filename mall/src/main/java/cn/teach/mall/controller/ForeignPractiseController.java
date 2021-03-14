package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.IForeignPractiseService;
import cn.teach.pojo.mall.entity.ForeignPractise;
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
}

