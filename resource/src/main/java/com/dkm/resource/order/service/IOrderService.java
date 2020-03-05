package com.dkm.resource.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dkm.resource.order.entity.Order;
import com.dkm.resource.order.entity.query.PageAllQuery;
import com.dkm.resource.order.entity.vo.OrderIdVo;
import com.dkm.resource.order.entity.vo.OrderNoVo;

import java.util.List;

/**
 * @author qf
 * @date 2020/3/3
 * @vesion 1.0
 **/
public interface IOrderService {


   /**
    * 返回全部列表
    * @return
    */
   List<Order> findAll();


   /**
    * 返回分页列表
    * @param query
    * @return
    */
   Page<Order> findPage(PageAllQuery query);


   /**
    * 增加
    * @param order
    */
   void add(Order order);


   /**
    * 修改
    * @param order
    */
   void update(Order order);


   /**
    * 根据ID获取实体
    * @param id
    * @return
    */
   Order findOne(Long id);


   /**
    * 批量删除
    * @param list
    */
   void delete(List<OrderIdVo> list);

   /**
    *   分页
    * @param vo
    * @return
    */
   Page<Order> findPage(OrderNoVo vo);

}
