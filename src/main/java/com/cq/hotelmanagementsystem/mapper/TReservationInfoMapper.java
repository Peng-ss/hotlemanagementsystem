package com.cq.hotelmanagementsystem.mapper;

import com.cq.hotelmanagementsystem.model.TReservationInfo;
<<<<<<< HEAD
=======
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
>>>>>>> 完成

public interface TReservationInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TReservationInfo record);

    int insertSelective(TReservationInfo record);

    TReservationInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TReservationInfo record);

    int updateByPrimaryKey(TReservationInfo record);
<<<<<<< HEAD
=======

    List<TReservationInfo> reservedReservation();

    List<TReservationInfo> reservedReservationByDate(@Param("date")String date);

    List<TReservationInfo> reservedReservationByRoomType(@Param("roomTypeId")Integer roomTypeId);

    List<TReservationInfo> reservedReservationByDateAndRoomType(@Param("date")String date,@Param("roomTypeId")Integer roomTypeId);

    List<TReservationInfo> reservedReservationByName(@Param("name")String name);
>>>>>>> 完成
}