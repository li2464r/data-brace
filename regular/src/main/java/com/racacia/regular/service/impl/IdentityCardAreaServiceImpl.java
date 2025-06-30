package com.racacia.regular.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.racacia.regular.model.dto.IdentityCardAreaDto;
import com.racacia.regular.model.vo.IdentityCardAreaVo;
import com.racacia.regular.service.IdentityCardAreaService;
import com.racacia.repository.model.po.IdentityCardArea;
import com.racacia.repository.service.GlobalRepository;
import love.racacia.bean.BeanUtil;
import love.racacia.blank.BlankUtil;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class IdentityCardAreaServiceImpl implements IdentityCardAreaService {

    private final GlobalRepository globalRepository;

    public IdentityCardAreaServiceImpl(GlobalRepository globalRepository) {
        this.globalRepository = globalRepository;
    }

    @Override
    public List<IdentityCardAreaVo> selectIdentityCardAreaList(IdentityCardAreaDto identityCardAreaDto) {
        LambdaQueryWrapper<IdentityCardArea> identityCardAreaLambdaQueryWrapper = Wrappers.lambdaQuery(IdentityCardArea.class);
        identityCardAreaLambdaQueryWrapper.eq(BlankUtil.isNotBlankString(identityCardAreaDto.getAreaCode()), IdentityCardArea::getAreaCode, identityCardAreaDto.getAreaCode());
        identityCardAreaLambdaQueryWrapper.eq(BlankUtil.isNotBlankString(identityCardAreaDto.getAreaName()), IdentityCardArea::getAreaName, identityCardAreaDto.getAreaName());
        List<IdentityCardArea> identityCardAreaList = globalRepository.getIdentityCardAreaRepository().getIdentityCardAreaMapper().selectList(identityCardAreaLambdaQueryWrapper);
        return BeanUtil.copyNestList(identityCardAreaList, IdentityCardAreaVo.class);
    }

    @Override
    public Map<String, List<IdentityCardAreaVo>> selectIdentityCardArea() {
        LambdaQueryWrapper<IdentityCardArea> identityCardAreaLambdaQueryWrapper = Wrappers.lambdaQuery(IdentityCardArea.class);
        List<IdentityCardArea> identityCardAreaList = globalRepository.getIdentityCardAreaRepository().getIdentityCardAreaMapper().selectList(identityCardAreaLambdaQueryWrapper);

        Map<String, List<IdentityCardAreaVo>> map = new HashMap<>();

        identityCardAreaList.stream()
                .collect(Collectors.groupingBy(identityCardArea -> identityCardArea.getAreaCode().substring(0, 3)))
                .forEach((key, value) -> map.put(key, BeanUtil.copyNestList(value, IdentityCardAreaVo.class)));
        return new TreeMap<>(Comparator.naturalOrder()) {{
            putAll(map);
        }};
    }

}




