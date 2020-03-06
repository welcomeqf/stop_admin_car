package com.dkm.resource.order.controller;

import com.dkm.aop.IsBean;
import com.dkm.constanct.CodeType;
import com.dkm.exception.ApplicationException;
import com.dkm.jwt.islogin.CheckToken;
import com.dkm.resource.order.entity.Order;
import com.dkm.resource.order.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qf
 * @date 2020/3/5
 * @vesion 1.0
 **/
@Api(tags = "订单Api")
@Slf4j
@RestController
@RequestMapping("/v1/order")
public class OrderController {

   @Autowired
   private IOrderService orderService;


   @ApiOperation(value = "返回所有", notes = "返回所有")
   @GetMapping("/queryAll")
   public List<Order> findAll () {
      return orderService.findAll();
   }
}
