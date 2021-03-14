package cn.teach.mall.service;

import cn.teach.common.mvc.Page;
import cn.teach.pojo.mall.entity.ForeignTeach;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 外聘教师教学工作量统计表 服务类
 * </p>
 *
 * @author MaZhuli
 * @since 2021-03-07
 */
public interface IForeignTeachService extends IService<ForeignTeach> {

    IPage<ForeignTeach> pageForForeignTeach(Page<ForeignTeach> page, Map<String, Object> param);
}
