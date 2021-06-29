package com.jaken.secondHand.service;

import com.jaken.secondHand.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jaken Xie
 * @since 2021-06-26
 */
public interface UserService extends IService<User> {

    List<User> showUserList();
    Boolean login(String userName,String userPwd);
    Boolean addUser(User user);
    Boolean isUnique(String userName);


}
