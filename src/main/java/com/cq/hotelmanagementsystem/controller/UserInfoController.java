package com.cq.hotelmanagementsystem.controller;

import com.cq.hotelmanagementsystem.model.TUserInfo;
import com.cq.hotelmanagementsystem.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.Map;

<<<<<<< HEAD
@Api(description = "用户信息控制器")
=======
@Api(description = "用户信息")
>>>>>>> 完成
@Controller
@RequestMapping(value = "/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

<<<<<<< HEAD
=======
    @ApiOperation(value = "查询所有的用户信息")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ModelAndView getAllUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",userInfoService.getAllUser());
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

>>>>>>> 完成
    @ApiOperation(value = "新增用户信息")
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public ModelAndView setNewUser(@RequestParam("account")String account,
                                   @RequestParam("password")String password,
                                   @RequestParam("jobNum")String jobNum,
                                   @RequestParam("isAdmin")Boolean isAdmin,
                                   @RequestParam("username")String username,
                                   @RequestParam("sex") Boolean sex,
                                   @RequestParam("teleNum") String teleNum,
                                   @RequestParam("isEnable")Boolean isEnable,
                                   @RequestParam(value = "remanks" ,required = false)String remanks
                                   ){
        Map<String,Object> map = new HashMap<>();
        TUserInfo tUserInfo = new TUserInfo();
        tUserInfo.setAccount(account);
        BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
        tUserInfo.setPassword(bCryptPasswordEncoder.encode(password));
        tUserInfo.setIsAdmin(isAdmin);
        tUserInfo.setIsEnable(isEnable);
        tUserInfo.setJobNum(jobNum);
        tUserInfo.setUsername(username);
        tUserInfo.setRemarks(remanks);
        tUserInfo.setSex(sex);
        tUserInfo.setTeleNum(teleNum);
        boolean b = userInfoService.setNewUser(tUserInfo);
        map.put("data",b);
        if (b){
            map.put("msg","新增成功");
        }else {
            map.put("msg","新增失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

<<<<<<< HEAD
    @ApiOperation(value = "修改密码")
    @RequestMapping(value = "/password",method = RequestMethod.POST)
    public ModelAndView setPassword(@RequestParam("account")String account,
                                    @RequestParam("oldPass")String oldPass,
                                    @RequestParam("newPass")String newPass){
        Map<String,Object> map = new HashMap<>();
        map.put("data",userInfoService.setPassword(account,oldPass,newPass));
        return  new ModelAndView(new MappingJackson2JsonView(),map);
=======
    @ApiOperation(value = "编辑用户信息")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ModelAndView updateUser(@RequestParam("id")Integer id,
                                   @RequestParam("account")String account,
                                   @RequestParam("password")String password,
                                   @RequestParam("jobNum")String jobNum,
                                   @RequestParam("isAdmin")Boolean isAdmin,
                                   @RequestParam("teleNum") String teleNum,
                                   @RequestParam("isEnable")Boolean isEnable,
                                   @RequestParam(value = "remanks" ,required = false)String remanks){
        Map<String,Object> map = new HashMap<>();
        TUserInfo tUserInfo = new TUserInfo();
        tUserInfo.setId(id);
        tUserInfo.setAccount(account);
        BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
        tUserInfo.setPassword(bCryptPasswordEncoder.encode(password));
        tUserInfo.setIsAdmin(isAdmin);
        tUserInfo.setIsEnable(isEnable);
        tUserInfo.setJobNum(jobNum);
        tUserInfo.setRemarks(remanks);
        tUserInfo.setTeleNum(teleNum);
        boolean b = userInfoService.updateUser(tUserInfo);
        map.put("data",b);
        if (b){
            map.put("msg","更新成功");
        }else {
            map.put("msg","更新失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value="删除用户")
    @RequestMapping(value="/dele",method = RequestMethod.POST)
    public ModelAndView deleUser(@RequestParam("id")Integer id){
        Map<String,Object> map = new HashMap<>();
        boolean b =userInfoService.deleUser(id);
        map.put("data",b);
        if (b){
            map.put("msg","删除成功");
        }else {
            map.put("msg","删除失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
>>>>>>> 完成
    }
}

