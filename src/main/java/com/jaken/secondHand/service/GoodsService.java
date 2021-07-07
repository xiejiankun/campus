package com.jaken.secondHand.service;

import com.jaken.secondHand.pojo.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
public interface GoodsService extends IService<Goods> {
    Map<String,Object> goodsLists(int currentPage);
    Map<String,Object> getGoodsByName(int currentPage,String goodsName);
    Goods showGoodsDetial(int goodsId);
    int addGoods(Goods goods);
    List<Goods> showMyGoods(int userId);
    int deleteMyGoods(int goodsId);
    int updateGoods(Goods goods);
}
