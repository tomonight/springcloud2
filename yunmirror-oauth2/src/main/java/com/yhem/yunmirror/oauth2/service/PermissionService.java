package com.yhem.yunmirror.oauth2.service;


import java.util.List;

import com.yhem.yunmirror.oauth2.entity.RcMenuEntity;

/**
 * Created by Mr.Yangxiufeng on 2017/12/29.
 * Time:12:37
 * ProjectName:Mirco-Service-Skeleton
 */
public interface PermissionService {
    List<RcMenuEntity> getPermissionsByRoleId(Integer roleId);
}
