package com.cq.hotelmanagementsystem.service;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public class CustomerInfoService {
=======
import com.cq.hotelmanagementsystem.mapper.TCustomerInfoMapper;
import com.cq.hotelmanagementsystem.model.TCustomerInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerInfoService {

    @Autowired
    private TCustomerInfoMapper tCustomerInfoMapper;

    public List<TCustomerInfo> getAllCustomer(){
        return tCustomerInfoMapper.getAllCustomer();
    }

    public Boolean setNewCustomer(TCustomerInfo tCustomerInfo){
        try{
            int i = tCustomerInfoMapper.insert(tCustomerInfo);
            if (i ==1){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public Boolean updateCustomer(TCustomerInfo tCustomerInfo){
        try{
            int i = tCustomerInfoMapper.updateByPrimaryKeySelective(tCustomerInfo);
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

    public Boolean deleCustomer(Integer id){
        try{
            int i = tCustomerInfoMapper.deleteByPrimaryKey(id);
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

    public TCustomerInfo selectByName(String customerName){
        return tCustomerInfoMapper.selectByName(customerName);
    }
>>>>>>> 完成
}
