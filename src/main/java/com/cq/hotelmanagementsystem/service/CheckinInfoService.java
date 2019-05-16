package com.cq.hotelmanagementsystem.service;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public class CheckinInfoService {
=======
import com.cq.hotelmanagementsystem.mapper.*;
import com.cq.hotelmanagementsystem.model.TBillInfo;
import com.cq.hotelmanagementsystem.model.TCkeckInfo;
import com.cq.hotelmanagementsystem.model.TCustomerInfo;
import com.cq.hotelmanagementsystem.model.TRoomType;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class CheckinInfoService {

    @Autowired
    private TCkeckInfoMapper tCkeckInfoMapper;
    @Autowired
    private TCustomerInfoMapper tCustomerInfoMapper;
    @Autowired
    private TGuestroomInfoMapper tGuestroomInfoMapper;
    @Autowired
    private TRoomTypeMapper tRoomTypeMapper;
    @Autowired
    private TBillInfoMapper tBillInfoMapper;

    @Transactional
    public Boolean setNewCheckInInfo(TCkeckInfo tCkeckInfo, TCustomerInfo tCustomerInfo) {
            tCustomerInfoMapper.insertOrUdateCustomer(tCustomerInfo);
            TBillInfo tBillInfo =new TBillInfo();
            tBillInfo.setBillNum(tCkeckInfo.getBillNum());
            tBillInfo.setCheckinTime(tCkeckInfo.getCheckinTime());
            tBillInfo.setCheckoutTime(tCkeckInfo.getCheckoutTime());
            tBillInfo.setCustomerId(tCustomerInfo.getId());
            tBillInfo.setGuestroomNum(tCkeckInfo.getGuestroomId()+"");
            tBillInfo.setPay(false);
            //计算需要支付的金额
            Integer roomTypeId = tGuestroomInfoMapper.selectGuestRoomByRoomId(tCkeckInfo.getGuestroomId());
            TRoomType tRoomType = tRoomTypeMapper.selectByPrimaryKey(roomTypeId);
            int day =ReservationInfoService.differentDays(tCkeckInfo.getCheckinTime(),tCkeckInfo.getCheckoutTime());
            BigDecimal pay = tRoomType.getPrice().multiply(new BigDecimal(day)).multiply(new BigDecimal(tRoomType.getDiscount())).divide(new BigDecimal(100));
            tBillInfo.setPayPrice(pay);
            //生成待支付账单
            int i = tBillInfoMapper.insert(tBillInfo);
            if (i ==1){
                //写入登记入住信息表
                tCkeckInfo.setCustomerId(tCustomerInfo.getId()+"");
                int i1 = tCkeckInfoMapper.insert(tCkeckInfo);
                if (i1 == 1){
                    //修改客房的状态
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(tCkeckInfo.getCheckinTime());
                    for(int d = 0;d<day;d++){
                        tGuestroomInfoMapper.checkinStateForGuestRoom(tCkeckInfo.getGuestroomId()+"",sdf.format(calendar.getTime()));
                        calendar.add(Calendar.DATE, 1);
                    }
                        return true;
                }
            }
        return false;
    }
>>>>>>> 完成
}
