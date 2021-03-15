package cn.teach.mall.service;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.TeachTeaching;
import cn.teach.pojo.mall.vo.RoleVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 教师教学工作量汇总表 服务类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface ITeachTeachingService extends IService<TeachTeaching> {
    IPage<TeachTeaching> pageForTeachTeaching(Page<TeachTeaching> page, Map<String, Object> param);
}
