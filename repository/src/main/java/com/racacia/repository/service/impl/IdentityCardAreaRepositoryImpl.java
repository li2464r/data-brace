package com.racacia.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.racacia.repository.mapper.IdentityCardAreaMapper;
import com.racacia.repository.model.po.IdentityCardArea;
import com.racacia.repository.service.IdentityCardAreaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class IdentityCardAreaRepositoryImpl extends ServiceImpl<IdentityCardAreaMapper, IdentityCardArea>
        implements IdentityCardAreaRepository {

    private final IdentityCardAreaMapper identityCardAreaMapper;

    public IdentityCardAreaRepositoryImpl(IdentityCardAreaMapper identityCardAreaMapper) {
        this.identityCardAreaMapper = identityCardAreaMapper;
    }

    @Override
    public IdentityCardAreaMapper getIdentityCardAreaMapper() {
        return identityCardAreaMapper;
    }
}




