package cn.teach.mall.controller;


import cn.teach.common.mvc.*;
import cn.teach.common.util.PageHelperUtil;
import cn.teach.mall.service.IForeignTeachService;
import cn.teach.pojo.mall.entity.ForeignTeach;
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
 * 外聘教师教学工作量统计表 前端控制器
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
@RestController
@RequestMapping("/foreignTeach")
public class ForeignTeachController {

    @Autowired
    private IForeignTeachService iForeignTeachService;

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
        Page<ForeignTeach> page = PageHelperUtil.getPageInfo(param);
        IPage<ForeignTeach> pageList = iForeignTeachService.pageForForeignTeach(page, param);
        return new ResultData<>(pageList.getTotal(), pageList.getRecords());
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 查看详情
     */
    @RequestMapping("/get")
    public ResponseEntity<ForeignTeach> get(Integer id) {
        return new ResponseEntity<>(ResultErrorCode.SUCCESS, "操作成功", iForeignTeachService.getById(id));
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 添加/修改
     */
    @RequestMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(ForeignTeach foreignTeach, HttpSession session) {
        if (foreignTeach.getId() != null && foreignTeach.getId() > 0) {
            if (foreignTeach.getStatus() == 1) {
                foreignTeach.setCommitTime(new Date());
            } else if (foreignTeach.getStatus() == 2 || foreignTeach.getStatus() == 3) {
                foreignTeach.setAuditTime(new Date());
                foreignTeach.setManagerId((Integer) session.getAttribute("managerId"));
            }
            return ResponseHelper.returnResponse(iForeignTeachService.updateById(foreignTeach));
        } else {
            foreignTeach.setCreateTime(new Date());
            foreignTeach.setStatus(0);
            foreignTeach.setJobNo(session.getAttribute("jobNo").toString());
            foreignTeach.setTeacherId((Integer) session.getAttribute("managerId"));
            foreignTeach.setTeacherName(session.getAttribute("managerName").toString());
            return ResponseHelper.returnResponse(iForeignTeachService.save(foreignTeach));
        }
    }

    /**
     * @Author: majie
     * @Date: 2021/3/10
     * @Description: 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity<ForeignTeach> deleteByid(Integer id) {
        return ResponseHelper.returnResponse(iForeignTeachService.removeById(id));
    }
}

