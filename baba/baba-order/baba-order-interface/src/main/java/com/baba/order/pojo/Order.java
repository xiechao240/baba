package com.baba.order.pojo;

import com.baba.order.pojo.OrderDetail;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author xiechao
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_order")
@ApiModel(value="Order对象", description="订单表")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private List<OrderDetail> orderDetails;

    @TableField(exist = false)
    private Integer status;

    @ApiModelProperty(value = "订单id")
    @TableId(value = "order_id", type = IdType.ASSIGN_UUID)
    private Long orderId;

    @ApiModelProperty(value = "总金额，单位为分")
    private Long totalPay;

    @ApiModelProperty(value = "实付金额。单位:分。如:20007，表示:200元7分")
    private Long actualPay;

    @ApiModelProperty(value = "promotion_ids")
    private String promotionIds;

    @ApiModelProperty(value = "支付类型，1、在线支付，2、货到付款")
    private Boolean paymentType;

    @ApiModelProperty(value = "邮费。单位:分。如:20007，表示:200元7分")
    private Long postFee;

    @ApiModelProperty(value = "订单创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "物流名称")
    private String shippingName;

    @ApiModelProperty(value = "物流单号")
    private String shippingCode;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "买家留言")
    private String buyerMessage;

    @ApiModelProperty(value = "买家昵称")
    private String buyerNick;

    @ApiModelProperty(value = "买家是否已经评价,0未评价，1已评价")
    private Boolean buyerRate;

    @ApiModelProperty(value = "收获地址（省）")
    private String receiverState;

    @ApiModelProperty(value = "收获地址（市）")
    private String receiverCity;

    @ApiModelProperty(value = "收获地址（区/县）")
    private String receiverDistrict;

    @ApiModelProperty(value = "收获地址（街道、住址等详细地址）")
    private String receiverAddress;

    @ApiModelProperty(value = "收货人手机")
    private String receiverMobile;

    @ApiModelProperty(value = "收货人邮编")
    private String receiverZip;

    @ApiModelProperty(value = "收货人")
    private String receiver;

    @ApiModelProperty(value = "发票类型(0无发票1普通发票，2电子发票，3增值税发票)")
    private Integer invoiceType;

    @ApiModelProperty(value = "订单来源：1:app端，2：pc端，3：M端，4：微信端，5：手机qq端")
    private Integer sourceType;


}
