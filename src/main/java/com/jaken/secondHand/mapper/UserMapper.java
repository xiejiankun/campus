package com.jaken.secondHand.mapper;

import com.jaken.secondHand.pojo.User;
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

@Repository
public interface UserMapper extends BaseMapper<User> {

}
