package com.yhem.yunmirror.oauth2.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhem.yunmirror.oauth2.entity.RcUserEntity;
import com.yhem.yunmirror.oauth2.repository.UserRepository;
import com.yhem.yunmirror.oauth2.service.UserService;

/**
 * Created by Mr.Yangxiufeng on 2017/12/27.
 * Time:15:13
 * ProjectName:Mirco-Service-Skeleton
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public RcUserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public void addUser(RcUserEntity user) {
		
		
	}
}
