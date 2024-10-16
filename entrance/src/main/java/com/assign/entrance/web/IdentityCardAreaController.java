package com.assign.entrance.web;

import com.assign.entrance.base.BaseController;
import com.assign.entrance.model.dto.IdentityCardAreaDto;
import com.assign.entrance.service.IdentityCardAreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tool.result.Result;

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
    @RequestMapping("/list")
    public Result selectIdentityCardAreaList(@RequestBody(required = false) IdentityCardAreaDto identityCardAreaDto) {
        return Result.ok().data(identityCardAreaService.selectIdentityCardAreaList(identityCardAreaDto));
    }

    /**
     * 查询身份信息城市区域code
     *
     * @author <a href="mailto:jieqiang.li-ext@ikang.com">jieqiang.li</a>
     * @date 2024/10/15 015 17:30
     */
    @RequestMapping("/group")
    public Result selectIdentityCardArea() {
        return Result.ok().data(identityCardAreaService.selectIdentityCardArea());
    }

}
