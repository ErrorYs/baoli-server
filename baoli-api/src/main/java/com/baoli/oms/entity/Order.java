package com.baoli.oms.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author ys
 * @since 2020-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("oms_order")
@ApiModel(value="Order对象", description="订单表")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id", type = IdType.ID_WORKER_STR)
    private String orderId;

    private Long memberId;

    private Long skuId;

    @ApiModelProperty(value = "数量")
    private Integer quantity;

    @ApiModelProperty(value = "商品单价")
    private BigDecimal skuPrice;

    @ApiModelProperty(value = "订单总价格")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "支付方式:0->未支付,1->余额,2->宝励豆,3->微信支付,4->支付宝,5->其他")
    private Boolean payType;

    @ApiModelProperty(value = "订单状态:0->待付款,1->代发货,2->已发货,3->已完成,4->待评价,5->已关闭,6->无效订单")
    private Boolean status;

    @ApiModelProperty(value = "订单类型:0->正常订单,1->秒杀订单")
    private Boolean orderType;

    @ApiModelProperty(value = "快递公司")
    private String deliveryCompany;

    @ApiModelProperty(value = "快递单号")
    private String deliverySn;

    @ApiModelProperty(value = "收货人")
    private String receiverName;

    @ApiModelProperty(value = "收货号码")
    private String receiverPhone;

    @ApiModelProperty(value = "收货邮编")
    private String receiverPostCode;

    @ApiModelProperty(value = "身份/直辖市")
    private String receiverProvince;

    @ApiModelProperty(value = "城市")
    private String receiverCity;

    @ApiModelProperty(value = "区")
    private String receiverRegion;

    @ApiModelProperty(value = "详细地址")
    private String receiverDetailAddress;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Boolean deleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "支付时间")
    private Date paymentTime;

    @ApiModelProperty(value = "发货时间")
    private Date deliveryTime;

    @ApiModelProperty(value = "确认收货时间")
    private Date receiveTime;

    @ApiModelProperty(value = "评论时间")
    private Date commentTime;


}