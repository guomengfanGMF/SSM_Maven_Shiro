package com.gmf.serviceImpl;

import com.gmf.entity.Gn;
import com.gmf.entity.User;
import com.gmf.mapper.UserMapper;
import com.gmf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    public User selUserByusercode(String usercode) {
        System.out.println("--userServiceImpl--");
        return userMapper.selUserByusercode(usercode);
    }

    public List<Gn> selAllgn() {
        return userMapper.selAllgn();
    }

    public List<String> selPercodeByuid(int uid) {
        return userMapper.selPercodeByuid(uid);
    }
}
