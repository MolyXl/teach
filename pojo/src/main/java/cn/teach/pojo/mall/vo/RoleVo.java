package cn.teach.pojo.mall.vo;

import cn.teach.pojo.mall.entity.Role;

import java.io.Serializable;

/**
 * @ClassName: RoleVo
 * @Description: 角色返回实体
 * @Author: MaZhuli
 * @Date: 2019/8/8 14:34
 * @Version: 1.0.0
 */
public class RoleVo extends Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员数量
     */
    private Integer managerCount;

    public Integer getManagerCount() {
        return managerCount;
    }

    public void setManagerCount(Integer managerCount) {
        this.managerCount = managerCount;
    }
}
