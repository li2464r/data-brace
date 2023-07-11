package com.assign.entrance.base;


import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import java.util.List;

/**
 * @author Administrator
 */
abstract public class BaseController {

    final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 设置请求分页数据(适用于 mybatisPlus)
     *
     * @param entity 泛型类
     * @return {@link Page<T>}
     */
    public <T> Page<T> startPage(Class<T> entity) {

        HttpServletRequest request = getRequest();
        //每页多少行
        String pageSize = request.getParameter("size");
        //当前页数
        String currentPage = request.getParameter("current");
        //排序字段 eg: [{"column":"age","asc":true}]
        String orders = request.getParameter("orders");

        //设置默认值
        if (Strings.isBlank(currentPage)) {
            currentPage = "1";
        }
        if (Strings.isBlank(pageSize)) {
            pageSize = "10";
        }

        Page<T> page = new Page<>(Long.parseLong(currentPage), Long.parseLong(pageSize));

        if (Strings.isNotBlank(orders)) {

            //字符串转List<OrderItem> 对象
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, OrderItem.class);
            try {
                List<OrderItem> ordersList = objectMapper.readValue(orders, javaType);
                //设置
                page.setOrders(ordersList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }

        return page;
    }

    /**
     * 获取request
     */
    protected HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            logger.error("获取 ServletRequestAttributes 异常");
            return null;
        }
        return attributes.getRequest();
    }
}
