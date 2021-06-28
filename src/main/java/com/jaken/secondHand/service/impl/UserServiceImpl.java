package com.jaken.secondHand.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jaken.secondHand.pojo.User;
import com.jaken.secondHand.mapper.UserMapper;
import com.jaken.secondHand.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> showUserList() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    @Override
    public Boolean login(String userName, String userPwd) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .eq("user_name",userName)
                .eq("user_pwd",userPwd);
        User user1 = userMapper.selectOne(wrapper);
        if (user1==null) return false;
        return true;
    }


}