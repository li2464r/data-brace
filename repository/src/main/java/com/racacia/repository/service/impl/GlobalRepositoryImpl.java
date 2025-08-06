package com.racacia.repository.service.impl;

import com.racacia.middleware.repository.MiddlewareRepository;
import com.racacia.repository.service.GlobalRepository;
import com.racacia.repository.service.IdentityCardAreaRepository;
import com.racacia.repository.service.UrbanRuralRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @date 2021/8/24 0024 17:01
 */
@Repository
public class GlobalRepositoryImpl implements GlobalRepository {

    private final IdentityCardAreaRepository identityCardAreaRepository;
    private final UrbanRuralRepository urbanRuralRepository;
    private final MiddlewareRepository middlewareRepository;


    public GlobalRepositoryImpl(IdentityCardAreaRepository identityCardAreaRepository,
                                UrbanRuralRepository urbanRuralRepository, MiddlewareRepository middlewareRepository) {
        this.identityCardAreaRepository = identityCardAreaRepository;
        this.urbanRuralRepository = urbanRuralRepository;
        this.middlewareRepository = middlewareRepository;
    }

    @Override
    public IdentityCardAreaRepository getIdentityCardAreaRepository() {
        return identityCardAreaRepository;
    }

    @Override
    public UrbanRuralRepository getUrbanRuralRepository() {
        return urbanRuralRepository;
    }

    @Override
    public MiddlewareRepository getMiddlewareRepository() {
        return middlewareRepository;
    }
}
