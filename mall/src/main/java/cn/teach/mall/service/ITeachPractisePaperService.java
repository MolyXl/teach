package cn.teach.mall.service;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.TeachPractisePaper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 实践环节毕业论文、学年论文、创新创业训练计划项目等业绩点统计表 服务类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface ITeachPractisePaperService extends IService<TeachPractisePaper> {

    IPage<TeachPractisePaper> pageForTeachPractisePaper(Page<TeachPractisePaper> page, Map<String, Object> param);
}
