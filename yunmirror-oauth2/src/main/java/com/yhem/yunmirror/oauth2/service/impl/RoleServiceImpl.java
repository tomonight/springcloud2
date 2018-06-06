package com.yhem.yunmirror.oauth2.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhem.yunmirror.oauth2.entity.RcRoleEntity;
import com.yhem.yunmirror.oauth2.repository.RoleRepository;
import com.yhem.yunmirror.oauth2.service.RoleService;

/**
 * Created by Mr.Yangxiufeng on 2017/12/29.
 * Time:12:31
 * ProjectName:Mirco-Service-Skeleton
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<RcRoleEntity> getRoleValuesByUserId(Integer userId) {
        return roleRepository.getRoleValuesByUserId(userId);
    }
}
