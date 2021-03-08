package cn.teach.mall.mapper;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.TeachTeaching;
import cn.teach.pojo.mall.vo.RoleVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Map;

/**
 * <p>
 * 教师教学工作量汇总表 Mapper 接口
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface TeachTeachingMapper extends BaseMapper<TeachTeaching> {

    IPage<TeachTeaching> pageForTeachTeaching(Page<TeachTeaching> page, Map<String, Object> param);
}
