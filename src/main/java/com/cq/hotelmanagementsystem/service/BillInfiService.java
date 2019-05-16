package com.cq.hotelmanagementsystem.service;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public class BillInfiService {
=======
import com.cq.hotelmanagementsystem.mapper.TBillInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BillInfiService {

    @Autowired
    private TBillInfoMapper tBillInfoMapper;

    public List<Map<String,Object>> selectNoPay() {
        return tBillInfoMapper.selectNoPay();
    }

    public List<Map<String,Object>> selectPay() {
        return tBillInfoMapper.selectPay();
    }

    public Boolean pay(Integer id) {
        try{
            int i = tBillInfoMapper.pay(id);
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
>>>>>>> 完成
}
