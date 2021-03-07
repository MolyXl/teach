package cn.teach.mall.mapper;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.Manager;
import cn.teach.pojo.mall.vo.ManagerVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 后台管理员 Mapper 接口
 * </p>
 *
 * @author MaZhuli
 * @since 2019-07-31
 */
public interface ManagerMapper extends BaseMapper<Manager> {

    IPage<ManagerVo> pageForManagerVo(Page<ManagerVo> page, @Param("param") Map<String, Object> param);
}
