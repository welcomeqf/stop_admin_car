package com.dkm.resource.order.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dkm.constanct.CodeType;
import com.dkm.exception.ApplicationException;
import com.dkm.resource.order.dao.OrderMapper;
import com.dkm.resource.order.entity.Order;
import com.dkm.resource.order.entity.query.PageAllQuery;
import com.dkm.resource.order.entity.vo.OrderIdVo;
import com.dkm.resource.order.entity.vo.OrderNoVo;
import com.dkm.resource.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author qf
 * @date 2020/3/3
 * @vesion 1.0
 **/
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order> implements IOrderService {


   @Override
   public List<Order> findAll() {
      return baseMapper.selectList(null);
   }

   @Override
   public Page<Order> findPage(PageAllQuery query) {

      //分页查询所有
      Page<Order> page = new Page<>();
      page.setCurrent(query.getCurrent());
      page.setSize(query.getSize());

      baseMapper.selectPage(page,null);
      return page;
   }

   @Override
   public void add(Order order) {
      int insert = baseMapper.insert(order);

      if (insert <= 0) {
         log.error("增加订单错误");
         throw new ApplicationException(CodeType.SERVICE_ERROR, "增加订单错误");
      }
   }

   @Override
   public void update(Order order) {
      int i = baseMapper.updateById(order);

      if (i <= 0) {
         log.error("修改订单错误");
         throw new ApplicationException(CodeType.SERVICE_ERROR, "修改订单错误");
      }
   }

   @Override
   public Order findOne(Long id) {
      return baseMapper.selectById(id);
   }

   @Override
   public void delete(List<OrderIdVo> list) {

      Integer integer = baseMapper.deleteAllOrder(list);

      if (integer <= 0) {
         log.error("批量删除失败");
         throw new ApplicationException(CodeType.SERVICE_ERROR, "批量删除有误");
      }

   }

   @Override
   public Page<Order> findPage(OrderNoVo vo) {


      return null;
   }
}
