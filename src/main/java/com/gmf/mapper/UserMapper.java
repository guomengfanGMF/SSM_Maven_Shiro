package com.gmf.mapper;

import com.gmf.entity.Gn;
import com.gmf.entity.User;

import java.util.List;

public interface UserMapper {

    public void saveUser(User user);
    public User selUserByusercode(String usercode);
    public List<Gn> selAllgn();
    public List<String> selPercodeByuid(int uid);
}
