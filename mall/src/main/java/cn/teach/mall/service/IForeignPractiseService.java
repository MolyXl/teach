package cn.teach.mall.service;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.ForeignPractise;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 外聘工作量汇总表 服务类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface IForeignPractiseService extends IService<ForeignPractise> {

    IPage<ForeignPractise> pageForForeignPractise(Page<ForeignPractise> page, Map<String, Object> param);
}
