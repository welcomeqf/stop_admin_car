package com.dkm.resource.order.entity.vo;

import com.dkm.data.PageUtils;
import lombok.Data;

/**
 * @author qf
 * @date 2020/3/3
 * @vesion 1.0
 **/
@Data
public class OrderNoVo extends PageUtils {

   /**
    * 单号
    */
   private String orderNo;
}
