package com.jaken.secondHand.mapper;

import com.jaken.secondHand.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
@Mapper
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

}
