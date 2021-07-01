package com.jaken.secondHand.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaken.secondHand.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {
    List<Goods> showGoodsList(Page<Goods> page);

}
