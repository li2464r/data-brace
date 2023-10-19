package com.assign.entrance.web;


import com.assign.entrance.base.exception.LibertyException;
import com.assign.entrance.model.dto.UrbanRuralDto;
import com.assign.entrance.service.UrbanRuralService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tool.result.Result;

@RestController
@RequestMapping("/urban/rural")
public class UrbanRuralController {

    private final UrbanRuralService urbanRuralService;

    public UrbanRuralController(UrbanRuralService urbanRuralService) {
        this.urbanRuralService = urbanRuralService;
    }

    /**
     * 递归查询子级城市
     *
     * @param urbanRuralDto {@link UrbanRuralDto}
     * @return Result {@link Result}
     * @author <a href="mailto:li2464r@163.com">R</a>
     * @date 2022/8/5 0005 10:29
     */
    @RequestMapping("/list/child")
    public Result selectChildUrbanRural(@RequestBody(required = false) UrbanRuralDto urbanRuralDto) throws LibertyException {
        return Result.ok().data(urbanRuralService.selectChildUrbanRural(urbanRuralDto));
    }

    /**
     * 查询同等级城市
     *
     * @param urbanRuralDto {@link UrbanRuralDto}
     * @return Result {@link Result}
     * @author <a href=":lmailtoi2464r@163.com">R</a>
     * @date 2022/8/5 0005 10:34
     */
    @RequestMapping("/list/level")
    public Result selectLevelUrbanRural(@RequestBody UrbanRuralDto urbanRuralDto) {
        return Result.ok().data(urbanRuralService.selectLevelUrbanRural(urbanRuralDto));
    }

    @RequestMapping("/insert")
    public Result insertUrbanRural() throws Exception {
        return Result.ok().data(urbanRuralService.insertUrbanRural());
    }

}
