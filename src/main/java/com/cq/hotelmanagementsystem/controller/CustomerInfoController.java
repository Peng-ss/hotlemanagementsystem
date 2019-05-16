package com.cq.hotelmanagementsystem.controller;

<<<<<<< HEAD
public class CustomerInfoController {
=======
import com.cq.hotelmanagementsystem.model.TCustomerInfo;
import com.cq.hotelmanagementsystem.service.CustomerInfoService;
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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api(description = "客户信息")
@Controller
@RequestMapping(value = "/customer")
public class CustomerInfoController {

    @Autowired
    private CustomerInfoService customerInfoService;

    @ApiOperation(value = "查询所有客户信息")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ModelAndView getAllCustomer(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",customerInfoService.getAllCustomer());
        return  new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "增加客户信息")
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public ModelAndView setNewCustomer(@RequestParam("customerName")String customerName,
                                       @RequestParam("sex")Boolean sex,
                                       @RequestParam("teleNum")String teleNum,
                                       @RequestParam("certificatesNum")String certificatesNum,
                                       @RequestParam(value = "remanks",required = false)String remanks
                                       ){
        Map<String,Object> map = new HashMap<>();
        TCustomerInfo tCustomerInfo = new TCustomerInfo();
        tCustomerInfo.setCustomerName(customerName);
        tCustomerInfo.setSex(sex);
        tCustomerInfo.setCertificatesNum(certificatesNum);
        tCustomerInfo.setTeleNum(teleNum);
        tCustomerInfo.setCreationTime(new Date());
        tCustomerInfo.setRemanks(remanks);
        boolean b = customerInfoService.setNewCustomer(tCustomerInfo);
        map.put("data",b);
        if (b){
            map.put("msg","新增成功");
        }else {
            map.put("msg","新增失败");
        }
        return  new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "编辑客户信息")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ModelAndView updateCutsomer(@RequestParam("id") Integer id,
                                       @RequestParam("customerName")String customerName,
                                       @RequestParam("sex")Boolean sex,
                                       @RequestParam("teleNum")String teleNum,
                                       @RequestParam("certificatesNum")String certificatesNum,
                                       @RequestParam(value = "remanks",required = false)String remanks){
        Map<String,Object> map = new HashMap<>();
        TCustomerInfo tCustomerInfo = new TCustomerInfo();
        tCustomerInfo.setId(id);
        tCustomerInfo.setCustomerName(customerName);
        tCustomerInfo.setSex(sex);
        tCustomerInfo.setTeleNum(teleNum);
        tCustomerInfo.setRemanks(remanks);
        tCustomerInfo.setCertificatesNum(certificatesNum);
        tCustomerInfo.setCreationTime(new Date());
        boolean b = customerInfoService.updateCustomer(tCustomerInfo);
        map.put("data",b);
        if (b){
            map.put("msg","更新成功");
        }else {
            map.put("msg","更新失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation("删除客户信息")
    @RequestMapping(value = "/dele",method = RequestMethod.POST)
    public ModelAndView deleCustomerInfo(@RequestParam("id")Integer id){
        Map<String,Object> map = new HashMap<>();
        boolean b =customerInfoService.deleCustomer(id);
        map.put("data",b);
        if (b){
            map.put("msg","删除成功");
        }else {
            map.put("msg","删除失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation("根据客户名字查找客户信息")
    @RequestMapping(value = "selectbyName",method =RequestMethod.GET)
    public ModelAndView selectByName(@RequestParam("customerName")String customerName){
        Map<String,Object> map = new HashMap<>();
        map.put("data",customerInfoService.selectByName(customerName));
        return  new ModelAndView(new MappingJackson2JsonView(),map);
    }
>>>>>>> 完成
}
