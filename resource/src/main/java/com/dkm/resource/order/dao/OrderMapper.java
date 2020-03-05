package com.dkm.resource.order.dao;

import com.dkm.IBaseMapper.IBaseMapper;
import com.dkm.resource.order.entity.Order;
import com.dkm.resource.order.entity.vo.OrderIdVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author qf
 * @date 2020/3/3
 * @vesion 1.0
 **/
@Component
public interface OrderMapper extends IBaseMapper<Order> {

   /**
    * 批量删除
    * @param list
    * @return
    */
   Integer deleteAllOrder(List<OrderIdVo> list);
}
