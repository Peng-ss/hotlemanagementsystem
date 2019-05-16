package com.cq.hotelmanagementsystem.mapper;

import com.cq.hotelmanagementsystem.model.TUserInfo;

<<<<<<< HEAD
public interface TUserInfoMapper {

=======
import java.util.List;

public interface TUserInfoMapper {

    List<TUserInfo> getAllUser();

>>>>>>> 完成
    TUserInfo selectByAccount(String account);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserInfo record);

    int insertSelective(TUserInfo record);

    TUserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUserInfo record);

    int updateByPrimaryKey(TUserInfo record);
}