package com.yhem.yunmirror.oauth2.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhem.yunmirror.oauth2.entity.RcMenuEntity;
import com.yhem.yunmirror.oauth2.repository.PermissionRepository;
import com.yhem.yunmirror.oauth2.service.PermissionService;

/**
 * Created by Mr.Yangxiufeng on 2017/12/29.
 * Time:12:38
 * ProjectName:Mirco-Service-Skeleton
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;
    @Override
    public List<RcMenuEntity> getPermissionsByRoleId(Integer roleId) {
        return permissionRepository.getPermissionsByRoleId(roleId);
    }
}
