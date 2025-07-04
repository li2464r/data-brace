package com.racacia.regular.web;

import com.racacia.regular.base.BaseController;
import com.racacia.regular.model.dto.IdentityCardAreaDto;
import com.racacia.regular.model.vo.IdentityCardAreaVo;
import com.racacia.regular.service.IdentityCardAreaService;
import love.racacia.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:jieqiang.li-ext@iakng.com">jieqiang.li</a>
 * @date 2024-10-15 17:27
 */
@RestController
@RequestMapping("/identity/card/area")
public class IdentityCardAreaController extends BaseController {

    private final IdentityCardAreaService identityCardAreaService;

    Logger logger = LoggerFactory.getLogger(getClass());

    public IdentityCardAreaController(IdentityCardAreaService identityCardAreaService) {
        this.identityCardAreaService = identityCardAreaService;
    }

    /**
     * 查询身份信息城市区域code
     *
     * @author <a href="mailto:jieqiang.li-ext@ikang.com">jieqiang.li</a>
     * @date 2024/10/15 015 17:30
     */
    @GetMapping("/list")
    public Result<List<IdentityCardAreaVo>> selectIdentityCardAreaList(@RequestBody(required = false) IdentityCardAreaDto identityCardAreaDto) {
        return Result.<List<IdentityCardAreaVo>>ok().data(identityCardAreaService.selectIdentityCardAreaList(identityCardAreaDto));
    }

    /**
     * 查询身份信息城市区域code
     *
     * @author <a href="mailto:jieqiang.li-ext@ikang.com">jieqiang.li</a>
     * @date 2024/10/15 015 17:30
     */
    @GetMapping("/group")
    public Result<Map<String, List<IdentityCardAreaVo>>> selectIdentityCardArea() {
        return Result.<Map<String, List<IdentityCardAreaVo>>>ok().data(identityCardAreaService.selectIdentityCardArea());
    }

}
