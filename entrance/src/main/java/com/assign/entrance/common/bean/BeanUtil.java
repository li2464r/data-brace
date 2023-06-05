package com.assign.entrance.common.bean;

import com.assign.entrance.common.json.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * description  对象转换 (依赖于springBeans)
 *
 * @author LJQ
 * @date 2019/12/9 10:01
 */
public class BeanUtil {

    /**
     * 将list<T>转成list<F>
     *
     * @param resource 源
     * @param target   目标
     * @return java.util.List<F>
     */
    public static <T, F> List<F> copyList(List<T> resource, Class<F> target) {
        ArrayList<F> list = new ArrayList<>(resource.size());
        for (T t : resource) {
            try {
                F f = target.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(t, f);
                list.add(f);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("复制对象失败");
            }
        }
        return list;
    }

    /**
     * 将Object转换成F
     *
     * @param resource 源
     * @param target   目标
     * @return F
     */
    public static <F> F copyObject(Object resource, Class<F> target) {
        F f = null;
        try {
            f = target.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(resource, f);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("复制对象失败");
        }
        return f;
    }

    /**
     * @param resource 源
     * @param target   目标
     * @return F
     * @description 将Object转换成F
     */
    public static <F> List<F> copyNestList(String resource, Class<F> target) {
        return JsonUtil.readValueList(resource, target);
    }

    /**
     * 将Object转换成F
     *
     * @param resource 源
     * @param target   目标
     * @return F
     */
    public static <T, F> List<F> copyNestList(List<T> resource, Class<F> target) {
        List<F> list;
        try {
            list = JsonUtil.readValueList(JsonUtil.createObjectMapper().writeValueAsString(resource), target);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


}


