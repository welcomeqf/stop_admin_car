package com.dkm.resource.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author qf
 * @date 2020/3/3
 * @vesion 1.0
 **/
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("tb_order")
public class Order extends Model<Order> {

   private Long orderId;

   private LocalDateTime createTime;

   private LocalDateTime inTime;

   private LocalDateTime closeTime;

   private Integer pay;

   private Integer payType;

   private Integer state;

   private Long userId;

   private Long parkId;

   private String orderNo;
}
