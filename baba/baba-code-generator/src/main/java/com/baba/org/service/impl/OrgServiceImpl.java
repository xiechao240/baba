package com.baba.org.service.impl;

import com.baba.org.pojo.Org;
import com.baba.org.mapper.OrgMapper;
import com.baba.org.service.OrgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组织架构表 服务实现类
 * </p>
 *
 * @author xiechao
 * @since 2020-04-24
 */
@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements OrgService {

}
