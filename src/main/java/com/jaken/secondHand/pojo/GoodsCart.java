package com.jaken.secondHand.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GoodsCart对象", description="")
public class GoodsCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "购物车号")
    private Integer cartId;

    @ApiModelProperty(value = "商品号")
    private Integer goodsId;








}
