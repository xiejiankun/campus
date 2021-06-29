package com.jaken.secondHand.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
@Data
@ApiModel(value="User对象", description="")
public class User {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String userPwd;

    @ApiModelProperty(value = "手机号")
    private String userPhone;

    @ApiModelProperty(value = "收货地址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "微信号")
    @TableField("wechat_num")
    private Double wechatNum;

    @ApiModelProperty(value = "信用分")
    @TableField("credit_score")
    private Double creditScore;
}
