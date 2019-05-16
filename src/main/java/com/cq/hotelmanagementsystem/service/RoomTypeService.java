package com.cq.hotelmanagementsystem.service;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public class RoomTypeService {
}
=======
import com.cq.hotelmanagementsystem.mapper.TRoomTypeMapper;
import com.cq.hotelmanagementsystem.model.TRoomType;
import com.cq.hotelmanagementsystem.model.TUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {

    @Autowired
    private TRoomTypeMapper tRoomTypeMapper;

    public Boolean setNewRoomType(TRoomType tRoomType){
        try{
            if (tRoomTypeMapper.insert(tRoomType) == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    public Boolean updateRoomType(TRoomType tRoomType){
        try{
            int i = tRoomTypeMapper.updateByPrimaryKeySelective(tRoomType);
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

    public Boolean deleRoomType(Integer id){
        try{
            int i = tRoomTypeMapper.deleteByPrimaryKey(id);
            if (i ==1){
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            return  false;
        }
    }

    public List<TRoomType> getRoomTypeAll(){
        return tRoomTypeMapper.getRoomTypeAll();
    }


}

>>>>>>> 完成
