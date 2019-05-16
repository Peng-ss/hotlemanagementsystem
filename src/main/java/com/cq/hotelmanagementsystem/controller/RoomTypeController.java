package com.cq.hotelmanagementsystem.controller;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;

@Controller
public class RoomTypeController {
=======
import com.cq.hotelmanagementsystem.model.TRoomType;
import com.cq.hotelmanagementsystem.service.RoomTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Api(description = "客房类型管理")
@Controller
@RequestMapping("/roomType")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @ApiOperation(value = "获取客房类型")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ModelAndView getRoomTypeAll(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",roomTypeService.getRoomTypeAll());
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "新增客房类型")
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public ModelAndView setNewRoomtype(@RequestParam("roomTypeName")String roomTypeName,
                                       @RequestParam("price") BigDecimal price,
                                       @RequestParam("discount")Integer discount,
                                       @RequestParam("isWindow")Boolean isWindow,
                                       @RequestParam(value = "remanks",required = false)String remanks){
        Map<String,Object> map = new HashMap<>();
        TRoomType tRoomType = new TRoomType();
        tRoomType.setRoomTypeName(roomTypeName);
        tRoomType.setDiscount(discount);
        tRoomType.setPrice(price);
        tRoomType.setIsWindow(isWindow);
        tRoomType.setRemanks(remanks);
        Boolean b = roomTypeService.setNewRoomType(tRoomType);
        map.put("data",b);
        if (b){
            map.put("msg","新增成功");
        }else {
            map.put("msg","新增失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "编辑客房类型")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ModelAndView updateRoomType(@RequestParam("id")Integer id,
                                       @RequestParam("roomTypeName")String roomTypeName,
                                       @RequestParam("price") BigDecimal price,
                                       @RequestParam("discount")Integer discount,
                                       @RequestParam("isWindow")Boolean isWindow,
                                       @RequestParam(value = "remanks",required = false)String remanks){
        Map<String,Object> map = new HashMap<>();
        TRoomType tRoomType = new TRoomType();
        tRoomType.setId(id);
        tRoomType.setRoomTypeName(roomTypeName);
        tRoomType.setDiscount(discount);
        tRoomType.setPrice(price);
        tRoomType.setIsWindow(isWindow);
        tRoomType.setRemanks(remanks);
        Boolean b =roomTypeService.updateRoomType(tRoomType);
        map.put("data",b);
        if (b){
            map.put("msg","更新成功");
        }else {
            map.put("msg","更新失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "删除客房类型")
    @RequestMapping(value = "dele",method = RequestMethod.POST)
    public ModelAndView deleRoomType(@RequestParam("id")Integer id){
        Map<String,Object> map = new HashMap<>();
        Boolean b = roomTypeService.deleRoomType(id);
        map.put("data",b);
        if (b){
            map.put("msg","删除成功");
        }else {
            map.put("msg","删除失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }
>>>>>>> 完成
}
