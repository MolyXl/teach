package cn.teach.pojo.mall.bo;

import cn.teach.pojo.mall.entity.Manager;

import java.io.Serializable;

/**
 * @ClassName: ManagerBo
 * @Description: 管理员实体类
 * @Author: MaZhuli
 * @Date: 2019/8/6 14:55
 * @Version: 1.0.0
 */
public class ManagerBo extends Manager implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
