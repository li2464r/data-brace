package com.racacia.repository.service;

import com.racacia.repository.MiddlewareRepository;

/**
 * @author Administrator
 */
public interface GlobalRepository {

    IdentityCardAreaRepository getIdentityCardAreaRepository();

    UrbanRuralRepository getUrbanRuralRepository();


    MiddlewareRepository getMiddlewareRepository();
}
