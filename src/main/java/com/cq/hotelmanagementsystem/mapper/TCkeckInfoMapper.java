package com.cq.hotelmanagementsystem.mapper;

import com.cq.hotelmanagementsystem.model.TCkeckInfo;

public interface TCkeckInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCkeckInfo record);

    int insertSelective(TCkeckInfo record);

    TCkeckInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCkeckInfo record);

    int updateByPrimaryKey(TCkeckInfo record);
}