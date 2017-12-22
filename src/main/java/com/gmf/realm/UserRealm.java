package com.gmf.realm;

import com.gmf.entity.User;
import com.gmf.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

public class UserRealm extends AuthorizingRealm {
    @Override
    public void setName(String name){
        super.setName("userRealm");
    }
    @Resource
    private UserService userService;
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("--授权--");
        //获得当前的身份
         User user=(User) principal.getPrimaryPrincipal();
        List<String> percodes=userService.selPercodeByuid(user.getId());

        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(percodes);
        return info;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("--认证--");
        String usercode=token.getPrincipal().toString();
        System.out.println("usercode:"+usercode);
        User user=userService.selUserByusercode(usercode);
        System.out.println("认证的："+user);
        if(user==null){
            return null;
        }
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());
        return info;
    }
}
