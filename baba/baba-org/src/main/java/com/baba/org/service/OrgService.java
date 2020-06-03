package com.baba.org.service;

import com.baba.org.pojo.Org;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 组织架构表，顶级节点：大立教育 服务类
 * </p>
 *
 * @author xiechao
 * @since 2020-04-24
 */
public interface OrgService extends IService<Org> {

    List<Org> queryOrgListTreeByOrgId(String orgId);
}
