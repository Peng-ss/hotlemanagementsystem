package com.cq.hotelmanagementsystem.mapper;

import com.cq.hotelmanagementsystem.model.TCustomerInfo;
<<<<<<< HEAD

public interface TCustomerInfoMapper {
=======
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCustomerInfoMapper {

    List<TCustomerInfo> getAllCustomer();

>>>>>>> 完成
    int deleteByPrimaryKey(Integer id);

    int insert(TCustomerInfo record);

    int insertSelective(TCustomerInfo record);

    TCustomerInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCustomerInfo record);

    int updateByPrimaryKey(TCustomerInfo record);
<<<<<<< HEAD
=======

    TCustomerInfo selectByName(@Param("customerName") String customerName);

    int insertOrUdateCustomer(TCustomerInfo record);
>>>>>>> 完成
}