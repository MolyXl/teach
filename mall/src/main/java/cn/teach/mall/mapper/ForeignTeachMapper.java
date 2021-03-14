package cn.teach.mall.mapper;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.ForeignTeach;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Map;

/**
 * <p>
 * 外聘教师教学工作量统计表 Mapper 接口
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface ForeignTeachMapper extends BaseMapper<ForeignTeach> {

    IPage<ForeignTeach> pageForForeignTeach(Page<ForeignTeach> page, Map<String, Object> param);
}
