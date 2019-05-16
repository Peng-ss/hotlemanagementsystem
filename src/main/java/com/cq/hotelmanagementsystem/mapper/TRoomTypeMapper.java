package com.cq.hotelmanagementsystem.mapper;

import com.cq.hotelmanagementsystem.model.TRoomType;

<<<<<<< HEAD
=======
import java.util.List;


>>>>>>> 完成
public interface TRoomTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TRoomType record);

    int insertSelective(TRoomType record);

    TRoomType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRoomType record);

    int updateByPrimaryKey(TRoomType record);
<<<<<<< HEAD
=======

    List<TRoomType> getRoomTypeAll();
>>>>>>> 完成
}