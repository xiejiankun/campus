package com.jaken.secondHand.pojo;

import java.io.Serializable;
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
@ApiModel(value="Img对象", description="")
public class Img implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图片号")
      private Integer imgId;

    @ApiModelProperty(value = "商品号")
    private Integer goodsId;

    @ApiModelProperty(value = "图片地址")
    private String imgAddr;

    @ApiModelProperty(value = "图片描述")
    private String imgDesc;


}
