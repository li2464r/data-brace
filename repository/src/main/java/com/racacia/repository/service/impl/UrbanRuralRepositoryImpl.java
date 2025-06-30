package com.racacia.repository.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.racacia.repository.mapper.UrbanRuralMapper;
import com.racacia.repository.model.po.UrbanRural;
import com.racacia.repository.service.UrbanRuralRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UrbanRuralRepositoryImpl extends ServiceImpl<UrbanRuralMapper, UrbanRural> implements UrbanRuralRepository {

    private final UrbanRuralMapper urbanRuralMapper;

    public UrbanRuralRepositoryImpl(UrbanRuralMapper urbanRuralMapper) {
        this.urbanRuralMapper = urbanRuralMapper;
    }

    @Override
    public UrbanRuralMapper getUrbanRuralMapper() {
        return urbanRuralMapper;
    }

}
