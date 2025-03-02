package com.yhem.yunmirror.oauth2.service.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yhem.yunmirror.oauth2.entity.RcMenuEntity;
import com.yhem.yunmirror.oauth2.entity.RcRoleEntity;
import com.yhem.yunmirror.oauth2.entity.RcUserEntity;
import com.yhem.yunmirror.oauth2.service.PermissionService;
import com.yhem.yunmirror.oauth2.service.RoleService;
import com.yhem.yunmirror.oauth2.service.UserService;

/**
 * Created by Mr.Yangxiufeng on 2017/12/27.
 * Time:16:37
 * ProjectName:Mirco-Service-Skeleton
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RcUserEntity userEntity = userService.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("用户【:" + username + "】不存在!");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        boolean enabled = true; // 
        boolean accountNonExpired = true; // 
        boolean credentialsNonExpired = true; // 
        boolean accountNonLocked = true; // 
        List<RcRoleEntity> roleValues = roleService.getRoleValuesByUserId(userEntity.getId());
        for (RcRoleEntity role:roleValues){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getValue());
            grantedAuthorities.add(grantedAuthority);
            List<RcMenuEntity> permissionList = permissionService.getPermissionsByRoleId(role.getId());
            for (RcMenuEntity menu:permissionList
                 ) {
                GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
                grantedAuthorities.add(authority);
            }
        }
        User user = new User(userEntity.getUsername(), userEntity.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;
    }
}
