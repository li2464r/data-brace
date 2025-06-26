package com.racacia.entrance.web;

import com.racacia.entrance.base.BaseController;
import com.racacia.entrance.model.dto.UrbanRuralDto;
import com.racacia.entrance.model.vo.UrbanRuralVo;
import com.racacia.entrance.service.UrbanRuralService;
import love.racacia.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/urban/rural")
public class UrbanRuralController extends BaseController {

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
    @GetMapping("/list/child")
    public Result<List<UrbanRuralVo>> selectChildUrbanRural(UrbanRuralDto urbanRuralDto) {
        return Result.<List<UrbanRuralVo>>ok().data(urbanRuralService.selectChildUrbanRural(urbanRuralDto));
    }

    /**
     * 查询同等级城市
     *
     * @param urbanRuralDto {@link UrbanRuralDto}
     * @return Result {@link Result}
     * @author <a href=":mailtoli2464r@163.com">R</a>
     * @date 2022/8/5 0005 10:34
     */
    @GetMapping("/list/level")
    public Result selectLevelUrbanRural(UrbanRuralDto urbanRuralDto) {
        return Result.<List<UrbanRuralVo>>ok().data(urbanRuralService.selectLevelUrbanRural(urbanRuralDto));
    }

    /**
     * 根据ID查询城市信息
     *
     * @param id 城市ID
     * @return Result {@link Result}
     * @author <a href="mailto:li2464r@163.com">R</a>
     */
    @GetMapping("/id")
    public Result<UrbanRuralVo> selectUrbanRuralById(@RequestParam("id") Integer id) {
        return Result.<UrbanRuralVo>ok().data(urbanRuralService.selectUrbanRuralById(id));
    }

    @PostMapping("/insert")
    public Result<Object> insertUrbanRural() throws Exception {
        return Result.ok().data(urbanRuralService.insertUrbanRural());
    }

    @GetMapping("/random")
    public Result<Object> random() {
        return Result.ok().data(urbanRuralService.random("", 84L));
    }

}
