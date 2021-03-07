package cn.teach.pojo.mall.vo;

import cn.teach.pojo.mall.entity.Manager;

import java.io.Serializable;

/**
 * @ClassName: CommentVo
 * @Description: 管理员返回实体类
 * @Author: MaZhuli
 * @Date: 2019/7/31 17:40
 * @Version: 1.0.0
 */
public class ManagerVo extends Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 状态
     */
    private String statusStr;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }
}
