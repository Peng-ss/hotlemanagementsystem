package com.cq.hotelmanagementsystem.mapper;

import com.cq.hotelmanagementsystem.model.TBillInfo;

<<<<<<< HEAD
=======
import java.util.List;
import java.util.Map;

>>>>>>> 完成
public interface TBillInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBillInfo record);

    int insertSelective(TBillInfo record);

    TBillInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBillInfo record);

    int updateByPrimaryKey(TBillInfo record);
<<<<<<< HEAD
=======

    List<Map<String,Object>> selectNoPay();

    List<Map<String,Object>>selectPay();

    int pay(Integer id);
>>>>>>> 完成
}