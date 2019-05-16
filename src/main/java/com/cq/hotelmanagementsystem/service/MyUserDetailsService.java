package com.cq.hotelmanagementsystem.service;

import com.cq.hotelmanagementsystem.mapper.TUserInfoMapper;
import com.cq.hotelmanagementsystem.model.TUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private TUserInfoMapper tUserInfoMapper;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        TUserInfo tUser = tUserInfoMapper.selectByAccount(account);
        return  new User(account,tUser.getPassword(),authorities);
    }
}
