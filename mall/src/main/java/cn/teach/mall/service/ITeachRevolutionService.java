package cn.teach.mall.service;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.TeachRevolution;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 教学改革增量业绩点统计表 服务类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface ITeachRevolutionService extends IService<TeachRevolution> {

    IPage<TeachRevolution> pageForTeachRevolution(Page<TeachRevolution> page, Map<String, Object> param);
}
