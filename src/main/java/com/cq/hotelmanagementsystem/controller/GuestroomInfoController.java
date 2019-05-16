package com.cq.hotelmanagementsystem.controller;

<<<<<<< HEAD
public class GuestroomInfoController {
=======
import com.cq.hotelmanagementsystem.model.TGuestroomInfo;
import com.cq.hotelmanagementsystem.service.GuestroomInfoService;
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
import java.util.HashMap;
import java.util.Map;

@Api(description = "客房信息管理")
@RequestMapping("/guestroom")
@Controller
public class GuestroomInfoController {

    @Autowired
    private GuestroomInfoService guestroomInfoService;

    @ApiOperation(value = "查看所有客房信息")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ModelAndView getAllGuestroom(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",guestroomInfoService.getAllGuestroom());
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "新建客房信息")
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public ModelAndView setNewGuestRoom(@RequestParam("roomId")String roomId,
                                        @RequestParam("roomTypeId")Integer roomTypeId,
                                        @RequestParam("roomName")String roomName,
                                        @RequestParam("floor")String floor,
                                        @RequestParam("state")Integer state,
                                        @RequestParam("isEnable")Boolean isEnable,
                                        @RequestParam("teleNum")String teleNum,
                                        @RequestParam("adminName")String adminName,
                                        @RequestParam(value = "remanks",required = false)String remanks,
                                        @RequestParam("date")String date){
        Map<String,Object> map = new HashMap<>();
        TGuestroomInfo tGuestroomInfo = new TGuestroomInfo();
        tGuestroomInfo.setAdminName(adminName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            tGuestroomInfo.setDate(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tGuestroomInfo.setFloor(floor);
        tGuestroomInfo.setIsEnable(isEnable);
        tGuestroomInfo.setRemanks(remanks);
        tGuestroomInfo.setRoomId(roomId);
        tGuestroomInfo.setRoomName(roomName);
        tGuestroomInfo.setRoomTypeId(roomTypeId);
        tGuestroomInfo.setState(state);
        tGuestroomInfo.setTeleNum(teleNum);
        boolean b = guestroomInfoService.setNewGuestRoom(tGuestroomInfo);
        map.put("data",b);
        if (b){
            map.put("msg","新增成功");
        }else {
            map.put("msg","新增失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }


    @ApiOperation(value = "查看所有空房")
    @RequestMapping(value = "/selectAllEmpty",method = RequestMethod.GET)
    public ModelAndView selectAllEmpty(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",guestroomInfoService.selectAllEmpty());
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "查看指定房间类型空房")
    @RequestMapping(value = "/selectEmptyByType",method = RequestMethod.GET)
    public ModelAndView selectEmptyByType(@RequestParam("id")Integer id){
        Map<String,Object> map = new HashMap<>();
        map.put("data",guestroomInfoService.selectEmptyByType(id));
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "查看指定时间空房")
    @RequestMapping(value = "/selectEmptyByDate",method = RequestMethod.GET)
    public ModelAndView selectEmptyByDate(@RequestParam("date")String date){
        Map<String,Object> map = new HashMap<>();
        map.put("data",guestroomInfoService.selectEmptyByDate(date));
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "查看指定时间和房间类型空房")
    @RequestMapping(value = "/selectEmptyByDateAndType",method = RequestMethod.GET)
    public ModelAndView selectEmptyByDateAndType(@RequestParam("date")String date,@RequestParam("id")Integer id){
        Map<String,Object> map = new HashMap<>();
        map.put("data",guestroomInfoService.selectEmptyByDateAndType(date,id));
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "删除客房信息")
    @RequestMapping(value = "/dele",method = RequestMethod.GET)
    public ModelAndView deleGuestRoom(@RequestParam("id")Integer id){
        Map<String,Object> map = new HashMap<>();
        boolean b =guestroomInfoService.deleGuestRoom(id);
        map.put("data",b);
        if (b){
            map.put("msg","删除成功");
        }else {
            map.put("msg","删除失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "编辑客房信息")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ModelAndView updateGuestRoom(@RequestParam("id")Integer id,
                                        @RequestParam("roomId")String roomId,
                                        @RequestParam("roomTypeId")Integer roomTypeId,
                                        @RequestParam("roomName")String roomName,
                                        @RequestParam("floor")String floor,
                                        @RequestParam("state")Integer state,
                                        @RequestParam("isEnable")Boolean isEnable,
                                        @RequestParam("teleNum")String teleNum,
                                        @RequestParam("adminName")String adminName,
                                        @RequestParam(value = "remanks",required = false)String remanks,
                                        @RequestParam("date")String date){

        Map<String,Object> map = new HashMap<>();
        TGuestroomInfo tGuestroomInfo = new TGuestroomInfo();
        tGuestroomInfo.setId(id);
        tGuestroomInfo.setAdminName(adminName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            tGuestroomInfo.setDate(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tGuestroomInfo.setFloor(floor);
        tGuestroomInfo.setIsEnable(isEnable);
        tGuestroomInfo.setRemanks(remanks);
        tGuestroomInfo.setRoomId(roomId);
        tGuestroomInfo.setRoomName(roomName);
        tGuestroomInfo.setRoomTypeId(roomTypeId);
        tGuestroomInfo.setState(state);
        tGuestroomInfo.setTeleNum(teleNum);
        boolean b = guestroomInfoService.updateGuestRoom(tGuestroomInfo);
        map.put("data",b);
        if (b){
            map.put("msg","更新成功");
        }else {
            map.put("msg","更新失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "根据id查看客房信息")
    @RequestMapping(value = "id",method = RequestMethod.GET)
    public ModelAndView selectById(@RequestParam("id")Integer id){
        Map<String,Object> map = new HashMap<>();
        map.put("data",guestroomInfoService.selectById(id));
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }
>>>>>>> 完成
}
