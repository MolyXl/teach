package cn.teach.mall.service;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.Manager;
import cn.teach.pojo.mall.vo.ManagerVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 后台管理员 服务类
 * </p>
 *
 * @author MaZhuli
 * @since 2019-07-31
 */
public interface IManagerService extends IService<Manager> {

    IPage<ManagerVo> pageForManagerVo(Page<ManagerVo> page, Map<String, Object> param);
}
