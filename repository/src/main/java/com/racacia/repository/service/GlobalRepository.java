package com.racacia.repository.service;

import com.racacia.middleware.repository.MiddlewareRepository;

/**
 * @author Administrator
 */
public interface GlobalRepository {

    IdentityCardAreaRepository getIdentityCardAreaRepository();

    UrbanRuralRepository getUrbanRuralRepository();


    MiddlewareRepository getMiddlewareRepository();
}
