package com.racacia.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.racacia.repository.mapper.UrbanRuralMapper;
import com.racacia.repository.model.po.UrbanRural;

public interface UrbanRuralRepository extends IService<UrbanRural> {

    UrbanRuralMapper getUrbanRuralMapper();

}
