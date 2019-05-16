package com.cq.hotelmanagementsystem.mapper;

import com.cq.hotelmanagementsystem.model.TGuestroomInfo;
<<<<<<< HEAD

public interface TGuestroomInfoMapper {
=======
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGuestroomInfoMapper {

    //查询所有的客房信息0421
    List<TGuestroomInfo> getAllGuestroom();

>>>>>>> 完成
    int deleteByPrimaryKey(Integer id);

    int insert(TGuestroomInfo record);

    int insertSelective(TGuestroomInfo record);

<<<<<<< HEAD
    TGuestroomInfo selectByPrimaryKey(Integer id);
=======
    TGuestroomInfo selectById(Integer id);
>>>>>>> 完成

    int updateByPrimaryKeySelective(TGuestroomInfo record);

    int updateByPrimaryKey(TGuestroomInfo record);
<<<<<<< HEAD
=======

    List<TGuestroomInfo> selectAllEmpty();

    List<TGuestroomInfo> selectEmptyByDate(@Param("date") String date);

    List<TGuestroomInfo> selectEmptyByType(@Param("id") Integer id);

    List<TGuestroomInfo> selectEmptyByDateAndType(@Param("date") String date, @Param("id") Integer id);

    //int setStateForGuestRoom(@Param("id") Integer id, String format, int i);

    int insertOrUdateGuestRoom(TGuestroomInfo tGuestroomInfo);

    int cancelStateForGuestRoom(Integer id);

    //修改为2
    int checkinStateForGuestRoom(@Param("roomId") String roomId, @Param("date") String date);

    //根据房间编号获取房间类型id
    Integer selectGuestRoomByRoomId(Integer roomId);

    //获取id
    int selectIdByRoomIdAndDate(@Param("roomId") String roomId, @Param("date") String date);

    //获取状态
    Integer selectStateIdByRoomIdAndDate(@Param("roomId") String roomId, @Param("date") String date);

>>>>>>> 完成
}