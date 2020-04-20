package com.baba.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单状态表
 * </p>
 *
 * @author xiechao
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_order_status")
@ApiModel(value="OrderStatus对象", description="订单状态表")
public class OrderStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    @TableId(value = "order_id", type = IdType.ASSIGN_UUID)
    private Long orderId;

    @ApiModelProperty(value = "状态：1、未付款 2、已付款,未发货 3、已发货,未确认 4、交易成功 5、交易关闭 6、已评价")
    private Integer status;

    @ApiModelProperty(value = "订单创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "付款时间")
    private LocalDateTime paymentTime;

    @ApiModelProperty(value = "发货时间")
    private LocalDateTime consignTime;

    @ApiModelProperty(value = "交易完成时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "交易关闭时间")
    private LocalDateTime closeTime;

    @ApiModelProperty(value = "评价时间")
    private LocalDateTime commentTime;


}
