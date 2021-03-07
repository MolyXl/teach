package cn.teach.mall.service.impl;

import cn.teach.mall.mapper.MenuMapper;
import cn.teach.mall.service.IMenuService;
import cn.teach.pojo.mall.entity.Menu;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author MaZhuli
 * @since 2019-07-31
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
