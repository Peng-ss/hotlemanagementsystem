package com.cq.hotelmanagementsystem.controller;

<<<<<<< HEAD
public class CheckinInfoController {
=======
import com.cq.hotelmanagementsystem.model.TCkeckInfo;
import com.cq.hotelmanagementsystem.model.TCustomerInfo;
import com.cq.hotelmanagementsystem.service.CheckinInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api(description = "入住登记信息")
@RequestMapping("/checkin")
@Controller
public class CheckinInfoController {

    @Autowired
    private CheckinInfoService checkinInfoService;

    @ApiOperation(value = "新增入住登记信息")
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public ModelAndView setNewCheckInInfo(@RequestParam("roomId")Integer roomId,
                                          @RequestParam("customerName")String customerName,
                                          @RequestParam("sex")Boolean sex,
                                          @RequestParam("teleNum")String teleNum,
                                          @RequestParam("certificatesNum")String certificatesNum,
                                          @RequestParam("checkinTime")String checkinTime,
                                          @RequestParam("checkoutTime")String checkoutTime,
                                          @RequestParam("userId") Integer userId,
                                          @RequestParam(value = "remarks",required = false)String remarks
                                          ){
        Map<String,Object> map = new HashMap<>();
        TCkeckInfo tCkeckInfo = new TCkeckInfo();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        tCkeckInfo.setBillNum(new Date().getTime()+"");
        try {
            tCkeckInfo.setCheckinTime(sdf.parse(checkinTime));
            tCkeckInfo.setCheckoutTime(sdf.parse(checkoutTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tCkeckInfo.setGuestroomId(roomId);
        tCkeckInfo.setUserId(userId);
        TCustomerInfo tCustomerInfo = new TCustomerInfo();
        tCustomerInfo.setCertificatesNum(certificatesNum);
        tCustomerInfo.setRemanks(remarks);
        tCustomerInfo.setCustomerName(customerName);
        tCustomerInfo.setTeleNum(teleNum);
        tCustomerInfo.setSex(sex);
        tCustomerInfo.setCreationTime(new Date());
        boolean b = checkinInfoService.setNewCheckInInfo(tCkeckInfo,tCustomerInfo);
        map.put("data",b);
        if (b){
            map.put("msg","新增成功");
        }else {
            map.put("msg","新增失败");
        }
        return  new ModelAndView(new MappingJackson2JsonView(),map);
    }
>>>>>>> 完成
}
