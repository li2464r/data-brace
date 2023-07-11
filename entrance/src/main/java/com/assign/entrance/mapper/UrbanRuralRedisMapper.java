package com.assign.entrance.mapper;


import com.assign.entrance.model.po.UrbanRural;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrbanRuralRedisMapper extends CrudRepository<UrbanRural,Integer> {
}
