package com.yhem.yunmirror.oauth2.service;


import java.util.List;

import com.yhem.yunmirror.oauth2.entity.RcRoleEntity;

/**
 * Created by Mr.Yangxiufeng on 2017/12/29.
 * Time:12:30
 * ProjectName:Mirco-Service-Skeleton
 */
public interface RoleService {
    List<RcRoleEntity> getRoleValuesByUserId(Integer userId);
}
