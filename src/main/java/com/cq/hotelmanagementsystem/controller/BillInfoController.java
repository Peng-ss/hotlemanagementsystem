package com.cq.hotelmanagementsystem.controller;

<<<<<<< HEAD
public class BillInfoController {
=======

import com.cq.hotelmanagementsystem.model.TRoomType;
import com.cq.hotelmanagementsystem.service.BillInfiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.Map;

@Api(description = "账单信息")
@RequestMapping("/bill")
@Controller
public class BillInfoController {

    @Autowired
    private BillInfiService billInfiService;

    @ApiOperation(value = "查询未结账的账单")
    @RequestMapping(value = "/selectNoPay",method = RequestMethod.GET)
    public ModelAndView selectNoPay(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",billInfiService.selectNoPay());
        return  new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "查询结账的账单")
    @RequestMapping(value = "/selectPay",method = RequestMethod.GET)
    public ModelAndView selectPay(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",billInfiService.selectPay());
        return  new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "支付")
    @RequestMapping(value = "/pay",method = RequestMethod.GET)
    public ModelAndView pay(@RequestParam("id")Integer id){
        Map<String,Object> map = new HashMap<>();
        Boolean b =billInfiService.pay(id);
        map.put("data",b);
        if (b){
            map.put("msg","更新成功");
        }else {
            map.put("msg","更新失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }
>>>>>>> 完成
}
