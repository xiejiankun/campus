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
@ApiModel(value="GoodsCart对象", description="")
public class GoodsCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "购物车号")
    private Integer cartId;

    @ApiModelProperty(value = "商品号")
    private Integer goodsId;

    @ApiModelProperty(value = "商品总额")
    private Integer goodsAmount;


}
