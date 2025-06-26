package com.racacia.entrance.base;


import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlInjectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.racacia.entrance.base.exception.LibertyException;
import jakarta.servlet.http.HttpServletRequest;
import love.racacia.blank.BlankUtil;
import love.racacia.json.JsonUtil;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

/**
 * @author Administrator
 */
public abstract class BaseController {

    final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 设置请求分页数据(适用于 mybatisPlus)
     *
     * @param entity 泛型类
     * @return {@link Page<T>}
     */
    public <T> Page<T> startPage(Class<T> entity) throws LibertyException {

        HttpServletRequest request = getRequest();
        // 每页多少行
        String pageSize = request.getParameter("size");
        // 当前页数
        String currentPage = request.getParameter("current");
        // 排序字段 eg: [{"column":"age","asc":true}]
        String orders = request.getParameter("orders");

        // 设置默认值
        if (Strings.isBlank(currentPage)) {
            currentPage = "1";
        }
        if (Strings.isBlank(pageSize)) {
            pageSize = "10";
        }

        Page<T> page = new Page<>(Long.parseLong(currentPage), Long.parseLong(pageSize));
        if (BlankUtil.isBlankString(orders)) {
            return page;
        }
        if (SqlInjectionUtils.check(orders)) {
            throw new LibertyException("排序参数不正确");
        }
        // 字符串转List<OrderItem> 对象
        List<OrderItem> ordersList = JsonUtil.readValueList(orders, OrderItem.class);
        // 排序参数
        page.setOrders(ordersList);
        return page;
    }

    /**
     * 获取request
     */
    protected HttpServletRequest getRequest() throws LibertyException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (null == attributes) {
            throw new LibertyException("获取 ServletRequestAttributes 异常");
        }
        return attributes.getRequest();
    }
}
