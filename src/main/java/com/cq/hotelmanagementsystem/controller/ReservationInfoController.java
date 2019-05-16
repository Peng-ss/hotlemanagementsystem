package com.cq.hotelmanagementsystem.controller;

<<<<<<< HEAD
public class ReservationInfoController {
=======
import com.cq.hotelmanagementsystem.model.TReservationInfo;
import com.cq.hotelmanagementsystem.service.ReservationInfoService;
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

@Api(description = "预定信息")
@Controller
@RequestMapping("/reservationInfo")
public class ReservationInfoController {

    @Autowired
    private ReservationInfoService reservationInfoService;

    @ApiOperation(value = "新增预定信息")
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public ModelAndView setNewReservation(@RequestParam("guestroomId")String guestroomId,
                                          @RequestParam("reservationName")String reservationName,
                                          @RequestParam("teleNum")String teleNum,
                                          @RequestParam("checkinTime")String checkinTime,
                                          @RequestParam("checkoutTime")String checkoutTime,
                                          @RequestParam(value = "remanks",required = false)String remanks
                                          ){
        Map<String,Object> map = new HashMap<>();
        TReservationInfo tReservationInfo = new TReservationInfo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            tReservationInfo.setCheckinTime(sdf.parse(checkinTime));
            tReservationInfo.setCheckoutTime(sdf.parse(checkoutTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tReservationInfo.setGuestroomId(guestroomId);
        tReservationInfo.setRemanks(remanks);
        tReservationInfo.setReservationName(reservationName);
        tReservationInfo.setTeleNum(teleNum);
        boolean b = reservationInfoService.setNewReservation(tReservationInfo);
        map.put("data",b);
        if (b){
            map.put("msg","新增成功");
        }else {
            map.put("msg","新增失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);

    }

    @ApiOperation(value = "取消预订")
    @RequestMapping(value = "/cancel",method = RequestMethod.GET)
    public  ModelAndView cancelReservation(@RequestParam("id")Integer id){
        Map<String,Object> map = new HashMap<>();
        boolean b =reservationInfoService.cancelReservation(id);
        map.put("data",b);
        if (b){
            map.put("msg","删除成功");
        }else {
            map.put("msg","删除失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "已预订信息")
    @RequestMapping(value = "/reserved",method = RequestMethod.GET)
    public ModelAndView reservedReservation(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",reservationInfoService.reservedReservation());
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "获取一条预订信息")
    @RequestMapping(value = "/reservedReservationById",method = RequestMethod.GET)
    public ModelAndView reservedReservationById(@RequestParam("id")Integer id){
        Map<String,Object> map = new HashMap<>();
        map.put("data",reservationInfoService.reservedReservationById(id));
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "搜索预订信息")
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public ModelAndView selectReservation(@RequestParam("selectType")String selectType,
                                          @RequestParam(value = "date",required = false)String date,
                                          @RequestParam(value = "roomTypeId",required = false)Integer roomTypeId){
        Map<String,Object> map = new HashMap<>();
        if ("date".equals(selectType)){
            map.put("data",reservationInfoService.reservedReservationByDate(date));
        }
        if ("roomType".equals(selectType)){
            map.put("data",reservationInfoService.reservedReservationByRoomType(roomTypeId));
        }
        if ("all".equals(selectType)){
            map.put("data",reservationInfoService.reservedReservationByDateAndRoomType(date,roomTypeId));
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @ApiOperation(value = "根据客户名称查询预订信息")
    @RequestMapping(value = "/name",method = RequestMethod.GET)
    public ModelAndView selectReservationByName(@RequestParam("name") String name){
        Map<String,Object> map = new HashMap<>();
        map.put("data",reservationInfoService.reservedReservationByName(name));
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }
>>>>>>> 完成
}
