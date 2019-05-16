package com.cq.hotelmanagementsystem.service;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public class GuestroomInfoService {
=======
import com.cq.hotelmanagementsystem.mapper.TGuestroomInfoMapper;
import com.cq.hotelmanagementsystem.model.TGuestroomInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GuestroomInfoService {

    @Autowired
    private TGuestroomInfoMapper tGuestroomInfoMapper;

    //获取所有的客房信息item
    public List<TGuestroomInfo> getAllGuestroom(){
        return tGuestroomInfoMapper.getAllGuestroom();
    }

    @Transactional
    public Boolean setNewGuestRoom(TGuestroomInfo tGuestroomInfo){
        Date firstDate = tGuestroomInfo.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDate);
        tGuestroomInfoMapper.insert(tGuestroomInfo);
        calendar.add(calendar.DATE,1);
        tGuestroomInfo.setDate(calendar.getTime());
        tGuestroomInfoMapper.insert(tGuestroomInfo);
        calendar.add(calendar.DATE,1);
        tGuestroomInfo.setDate(calendar.getTime());
        tGuestroomInfoMapper.insert(tGuestroomInfo);
        return true;
    }

    public List<TGuestroomInfo> selectAllEmpty(){
        return tGuestroomInfoMapper.selectAllEmpty();
    }

    public List<TGuestroomInfo> selectEmptyByDate(String date){
        return  tGuestroomInfoMapper.selectEmptyByDate(date);
    }

    public List<TGuestroomInfo> selectEmptyByType(Integer id){ return tGuestroomInfoMapper.selectEmptyByType(id); }

    public List<TGuestroomInfo> selectEmptyByDateAndType(String date,Integer id){
        return  tGuestroomInfoMapper.selectEmptyByDateAndType(date,id);
    }

    public Boolean updateGuestRoom(TGuestroomInfo tGuestroomInfo){
        try{
            int i = tGuestroomInfoMapper.updateByPrimaryKeySelective(tGuestroomInfo);
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

    public Boolean deleGuestRoom(Integer id){
        try{
            int i = tGuestroomInfoMapper.deleteByPrimaryKey(id);
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

    //设置房间的状态为预订
    @Transactional
    public Map<String,Object> setStateForGuestRoom(String id, String date, Integer day)  {
        Map<String,Object> map = new HashMap<>();
        TGuestroomInfo tGuestroomInfo =  tGuestroomInfoMapper.selectById(Integer.parseInt(id));
        map.put("type",tGuestroomInfo.getRoomTypeId());
        List<Integer> list = new ArrayList<>();
        if (tGuestroomInfo != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            try {
                calendar.setTime(sdf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            for (int i = 0;i<day;i++){
                //tGuestroomInfo.setId(null);
                Calendar calendar1 = calendar;
                tGuestroomInfo.setDate(calendar1.getTime());
                String roomId = tGuestroomInfo.getRoomId();
                String date1 = new SimpleDateFormat("yyyy-MM-dd").format(tGuestroomInfo.getDate());
                Integer a = tGuestroomInfoMapper.selectStateIdByRoomIdAndDate(roomId,date1);
                if ( null == a || a.equals(0) ){
                    tGuestroomInfoMapper.insertOrUdateGuestRoom(tGuestroomInfo);
                    Integer i1 = tGuestroomInfo.getId();
                    if (0==i1){
                        i1= tGuestroomInfoMapper.selectIdByRoomIdAndDate(tGuestroomInfo.getRoomId(),new SimpleDateFormat("yyyy-MM-dd").format(tGuestroomInfo.getDate()));
                    }
                    list.add(i1);
                }else {
                    return null;
                }
                calendar.add(Calendar.DATE, 1);
            }
           map.put("id",list);
        }
        return map;
    }

    //取消预订
    @Transactional
    public Boolean cancelStateForGuestRoom(String id){
        String[] strArr = id.split(",");
        int num = 0;
        for (int i= 0;i<strArr.length;i++){
            num += tGuestroomInfoMapper.cancelStateForGuestRoom(Integer.parseInt(strArr[i]));
        }
        if (num == strArr.length){
            return true;
        }
        return false;
    }


    public TGuestroomInfo selectById(Integer id) {
        return tGuestroomInfoMapper.selectById(id);
    }
>>>>>>> 完成
}
