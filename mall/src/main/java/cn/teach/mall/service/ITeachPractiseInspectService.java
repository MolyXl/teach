package cn.teach.mall.service;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.TeachPractiseInspect;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 实践环节专业学科竞赛业绩点统计表 服务类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface ITeachPractiseInspectService extends IService<TeachPractiseInspect> {

    IPage<TeachPractiseInspect> pageForTeachPractiseInspect(Page<TeachPractiseInspect> page, Map<String, Object> param);
}
