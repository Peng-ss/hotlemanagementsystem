package com.cq.hotelmanagementsystem.service;

import com.cq.hotelmanagementsystem.mapper.TUserInfoMapper;
import com.cq.hotelmanagementsystem.model.TUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 完成
@Service
public class UserInfoService {

    @Autowired
    private TUserInfoMapper tUserInfoMapper;

<<<<<<< HEAD
=======
    public List<TUserInfo> getAllUser(){
        return tUserInfoMapper.getAllUser();
    }

>>>>>>> 完成
    public Boolean setNewUser(TUserInfo tUserInfo){
        try{
            if (tUserInfoMapper.insert(tUserInfo) == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

<<<<<<< HEAD
    public Boolean setPassword(String account,String oldPass,String newPass){
        TUserInfo tUserInfo = tUserInfoMapper.selectByAccount(account);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Boolean b= bCryptPasswordEncoder.matches(oldPass,tUserInfo.getPassword());
        if (b) {
            TUserInfo tUserInfo1 = new TUserInfo();
            tUserInfo1.setAccount(account);
            tUserInfo1.setPassword(bCryptPasswordEncoder.encode(newPass));
            tUserInfoMapper.updateByPrimaryKeySelective(tUserInfo1);
            return true;
        }else {
            return false;
        }
=======
    public Boolean updateUser(TUserInfo tUserInfo){
        try{
            int i = tUserInfoMapper.updateByPrimaryKeySelective(tUserInfo);
            if (i ==1){
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            return false;
        }

    }

    public Boolean deleUser(Integer id){
        try{
            int i = tUserInfoMapper.deleteByPrimaryKey(id);
            if (i ==1){
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            return  false;
        }
>>>>>>> 完成
    }
}
