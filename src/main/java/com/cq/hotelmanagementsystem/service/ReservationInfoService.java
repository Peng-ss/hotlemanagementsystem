package com.cq.hotelmanagementsystem.service;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public class ReservationInfoService {
=======
import com.cq.hotelmanagementsystem.mapper.TGuestroomInfoMapper;
import com.cq.hotelmanagementsystem.mapper.TReservationInfoMapper;
import com.cq.hotelmanagementsystem.model.TGuestroomInfo;
import com.cq.hotelmanagementsystem.model.TReservationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReservationInfoService {

    @Autowired
    private TReservationInfoMapper tReservationInfoMapper;

    @Autowired
    private GuestroomInfoService guestroomInfoService;

    @Transactional
    public Boolean setNewReservation(TReservationInfo tReservationInfo){
        Map<String,Object> map = new HashMap<>();
        map = guestroomInfoService.setStateForGuestRoom(tReservationInfo.getGuestroomId(),
                    new SimpleDateFormat("yyyy-MM-dd").format(tReservationInfo.getCheckinTime()),
                    differentDays(tReservationInfo.getCheckinTime(),tReservationInfo.getCheckoutTime()));
        List<Integer> list = new ArrayList<>();
        list = (List<Integer>) map.get("id");
        if (list.size() !=0){
            String str= "";
            for (int i = 0;i<list.size();i++){
                tReservationInfo.setGuestroomId("");
                if (i ==list.size()-1){
                    str += list.get(i)+"";
                }else {
                    str += list.get(i)+",";
                }
            }
            tReservationInfo.setGuestroomId(str);
            tReservationInfo.setGuestroomTypeId(Integer.parseInt(map.get("type").toString()));
            if (tReservationInfoMapper.insert(tReservationInfo) == 1){
                return true;
            }
        }
        return false;
    }

    @Transactional
    public Boolean cancelReservation(Integer id){
        TReservationInfo  tReservationInfo= new TReservationInfo();
        tReservationInfo = tReservationInfoMapper.selectByPrimaryKey(id);
        boolean b = guestroomInfoService.cancelStateForGuestRoom(tReservationInfo.getGuestroomId());
        if (b){
            if (tReservationInfoMapper.deleteByPrimaryKey(id) == 1){
                return true;
            }
        }
        return false;
    }

    public List<TReservationInfo> reservedReservation(){
        return  tReservationInfoMapper.reservedReservation();
    }

    public TReservationInfo reservedReservationById(Integer id) {
        return tReservationInfoMapper.selectByPrimaryKey(id);
    }

    public List<TReservationInfo> reservedReservationByDate(String date){
        return  tReservationInfoMapper.reservedReservationByDate(date);
    }
    public List<TReservationInfo> reservedReservationByRoomType(Integer roomTypeId){
        return  tReservationInfoMapper.reservedReservationByRoomType(roomTypeId);
    }
    public List<TReservationInfo> reservedReservationByDateAndRoomType(String date,Integer roomTypeId){
        return  tReservationInfoMapper.reservedReservationByDateAndRoomType(date,roomTypeId);
    }

    /**
     * date2比date1多的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1, Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }


    public List<TReservationInfo> reservedReservationByName(String name) {
        return tReservationInfoMapper.reservedReservationByName(name);
    }
>>>>>>> 完成
}
