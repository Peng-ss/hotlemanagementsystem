package com.cq.hotelmanagementsystem.controller;

import com.cq.hotelmanagementsystem.mapper.TUserInfoMapper;
import com.cq.hotelmanagementsystem.model.TUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private TUserInfoMapper tUserInfoMapper;

    @RequestMapping(value = "/success")
    public ModelAndView loginSuccess(HttpServletRequest httpServletRequest){
        Map<String,Object> map = new HashMap<>();
        String account = httpServletRequest.getParameter("username");
        TUserInfo tUserInfo = tUserInfoMapper.selectByAccount(account);
        map.put("data",tUserInfo);
        map.put("isSuccess",true);
        return new ModelAndView(new MappingJackson2JsonView(),map);

    }

    @RequestMapping(value = "/failure")
    public ModelAndView loginFailure(){
        Map<String,Object> map = new HashMap<>();
        map.put("data","");
        map.put("isSuccess",false);
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

}
