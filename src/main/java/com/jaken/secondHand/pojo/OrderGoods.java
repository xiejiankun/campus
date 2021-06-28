package com.jaken.secondHand.pojo;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="OrderGoods对象", description="")
public class OrderGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单号")
    private Integer orderId;

    @ApiModelProperty(value = "商品号")
    private Integer goodsId;

    @ApiModelProperty(value = "商品数量")
    private String goodsAmount;


}
