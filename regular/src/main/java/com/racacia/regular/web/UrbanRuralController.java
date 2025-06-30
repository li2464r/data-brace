package com.racacia.regular.web;

import com.racacia.regular.base.BaseController;
import com.racacia.regular.model.dto.UrbanRuralDto;
import com.racacia.regular.model.vo.UrbanRuralVo;
import com.racacia.regular.service.UrbanRuralService;
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

    /**
     * 根据ID数组查询城市信息列表
     *
     * @param ids 城市ID数组
     * @return Result {@link Result}
     * @author <a href="mailto:li2464r@163.com">R</a>
     */
    @GetMapping("/ids")
    public Result<List<UrbanRuralVo>> selectUrbanRuralByIds(@RequestParam("ids") List<Integer> ids) {
        return Result.<List<UrbanRuralVo>>ok().data(urbanRuralService.selectUrbanRuralByIds(ids));
    }

    /**
     * 根据PID查询城市信息
     *
     * @param pid 城市ID
     * @return Result {@link Result}
     * @author <a href="mailto:li2464r@163.com">R</a>
     */
    @GetMapping("/pid")
    public Result<List<UrbanRuralVo>> selectUrbanRuralByPid(@RequestParam("pid") Integer pid) {
        return Result.<List<UrbanRuralVo>>ok().data(urbanRuralService.selectUrbanRuralByPid(pid));
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
