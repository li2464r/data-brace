package com.assign.entrance.service;


import com.assign.entrance.model.dto.IdentityCardAreaDto;
import com.assign.entrance.model.po.IdentityCardArea;
import com.assign.entrance.model.vo.IdentityCardAreaVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;


public interface IdentityCardAreaService extends IService<IdentityCardArea> {

    /**
     * 查询身份信息城市区域code
     *
     * @author <a href="mailto:jieqiang.li-ext@ikang.com">jieqiang.li</a>
     * @date 2024/10/15 015 17:30
     */
    List<IdentityCardAreaVo> selectIdentityCardAreaList(IdentityCardAreaDto identityCardAreaDto);

    Map<String, List<IdentityCardAreaVo>> selectIdentityCardArea();
}
