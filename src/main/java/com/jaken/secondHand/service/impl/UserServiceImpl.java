package com.jaken.secondHand.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jaken.secondHand.config.Md5;
import com.jaken.secondHand.pojo.User;
import com.jaken.secondHand.mapper.UserMapper;
import com.jaken.secondHand.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
    private Md5 md5 = new Md5();

    @Override
    public Integer login(String userName, String userPwd) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .select("user_id","user_pwd")
                .eq("user_name",userName);
        User user = userMapper.selectOne(wrapper);
        if (user==null) return 0;
        try {
            if (md5.EncoderByMd5(userPwd).equals(user.getUserPwd())) {
                System.out.println("=========="+user.getUserId());
                return user.getUserId();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Boolean addUser(User user) {
        try {
            user.setUserPwd(md5.EncoderByMd5(user.getUserPwd()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int i = userMapper.insert(user);
        if(i==1) return true;
        return false;
    }

    @Override
    public Boolean isUnique(String userName) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .select("user_name")
                .eq("user_name",userName);
        User user = userMapper.selectOne(wrapper);
        if(user==null) return true;
        return false;
    }


}
