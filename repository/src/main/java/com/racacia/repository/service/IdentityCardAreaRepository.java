package com.racacia.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.racacia.repository.mapper.IdentityCardAreaMapper;
import com.racacia.repository.model.po.IdentityCardArea;

public interface IdentityCardAreaRepository extends IService<IdentityCardArea> {

    IdentityCardAreaMapper getIdentityCardAreaMapper();
}
