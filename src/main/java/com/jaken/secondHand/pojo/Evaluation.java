package com.jaken.secondHand.pojo;

import java.util.Date;
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
@ApiModel(value="Evaluation对象", description="")
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评价编号")
    private Integer evaId;

    @ApiModelProperty(value = "评价人ID")
    private Integer userId;

    @ApiModelProperty(value = "评价商品ID")
    private Integer goodsId;

    @ApiModelProperty(value = "评价时间")
    private Date evaTime;

    @ApiModelProperty(value = "评价内容")
    private String evaContent;

    @ApiModelProperty(value = "评分，最低分为0分，最高分为5 分，必须是整数")
    private Integer score;





}
