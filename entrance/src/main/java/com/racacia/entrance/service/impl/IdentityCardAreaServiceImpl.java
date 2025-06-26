package com.racacia.entrance.service.impl;

import com.racacia.entrance.mapper.IdentityCardAreaMapper;
import com.racacia.entrance.model.dto.IdentityCardAreaDto;
import com.racacia.entrance.model.po.IdentityCardArea;
import com.racacia.entrance.model.vo.IdentityCardAreaVo;
import com.racacia.entrance.service.IdentityCardAreaService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.tool.bean.BeanUtil;
import org.tool.blank.BlankUtil;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class IdentityCardAreaServiceImpl extends ServiceImpl<IdentityCardAreaMapper, IdentityCardArea>
        implements IdentityCardAreaService {

    @Override
    public List<IdentityCardAreaVo> selectIdentityCardAreaList(IdentityCardAreaDto identityCardAreaDto) {
        LambdaQueryWrapper<IdentityCardArea> identityCardAreaLambdaQueryWrapper = Wrappers.lambdaQuery(IdentityCardArea.class);
        identityCardAreaLambdaQueryWrapper.eq(BlankUtil.isNotBlankString(identityCardAreaDto.getAreaCode()), IdentityCardArea::getAreaCode, identityCardAreaDto.getAreaCode());
        identityCardAreaLambdaQueryWrapper.eq(BlankUtil.isNotBlankString(identityCardAreaDto.getAreaName()), IdentityCardArea::getAreaName, identityCardAreaDto.getAreaName());
        List<IdentityCardArea> identityCardAreaList = baseMapper.selectList(identityCardAreaLambdaQueryWrapper);
        return BeanUtil.copyNestList(identityCardAreaList, IdentityCardAreaVo.class);
    }

    @Override
    public Map<String, List<IdentityCardAreaVo>> selectIdentityCardArea() {
        LambdaQueryWrapper<IdentityCardArea> identityCardAreaLambdaQueryWrapper = Wrappers.lambdaQuery(IdentityCardArea.class);
        List<IdentityCardArea> identityCardAreaList = baseMapper.selectList(identityCardAreaLambdaQueryWrapper);

        Map<String, List<IdentityCardAreaVo>> map = new HashMap<>();

        identityCardAreaList.stream()
                .collect(Collectors.groupingBy(identityCardArea -> identityCardArea.getAreaCode().substring(0, 3)))
                .forEach((key, value) -> map.put(key, BeanUtil.copyNestList(value, IdentityCardAreaVo.class)));
        return new TreeMap<>(Comparator.naturalOrder()) {{
            putAll(map);
        }};
    }

}




