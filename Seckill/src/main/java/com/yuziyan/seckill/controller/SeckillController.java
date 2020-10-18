package com.yuziyan.seckill.controller;

import cn.hutool.core.util.ObjectUtil;
import com.yuziyan.seckill.dto.ResponseResult;
import com.yuziyan.seckill.dto.SeckillUrl;
import com.yuziyan.seckill.entity.SeckillItem;
import com.yuziyan.seckill.entity.User;
import com.yuziyan.seckill.exception.SeckillException;
import com.yuziyan.seckill.exception.UserException;
import com.yuziyan.seckill.service.SeckillItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class SeckillController {

    @Autowired
    SeckillItemService seckillItemService;

    @RequestMapping("/getSeckillItemList")
    public String getSeckillItemList(Model model){
        List<SeckillItem> seckillItemList = seckillItemService.getSeckillItemList();
        model.addAttribute("seckillItemList", seckillItemList);
        return "itemList";
    }


    @RequestMapping("/itemDetail/{itemId}")
    public String itemDetail(@PathVariable("itemId")Integer itemId, Model model){
        System.out.println("SeckillController.toItemDetail");
        if (itemId <= 0) {
            throw new SeckillException("无效的参数");
        }
        SeckillItem seckillItem = seckillItemService.getSeckillItem(itemId);
        if (ObjectUtil.isEmpty(seckillItem)) {
            throw new SeckillException("没有这个商品");
        }
        model.addAttribute("seckillItem",seckillItem);
        return "itemDetail";
    }

    //返回服务器的当前时间
    @RequestMapping("/getServerTime")
    @ResponseBody
    public ResponseResult<Long> getServerTime(){
        return new ResponseResult<>(true,new Date().getTime(),"ok");
    }

    //获取商品的秒杀url
    @RequestMapping(value = "/getSeckillUrl/{itemId}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<SeckillUrl> getSeckillUrl(@PathVariable("itemId") int itemId, HttpSession session){
        //后端验证：
        if (ObjectUtil.isEmpty(session.getAttribute("user"))) {
            throw new UserException("尚未登陆");
        }
        ResponseResult<SeckillUrl> result = new ResponseResult<>();
        try {
            //获取seckillUrl 设置响应信息
            SeckillUrl seckillUrl = seckillItemService.getSeckillUrl(itemId);
            result.setSuccess(true);
            result.setData(seckillUrl);
            result.setMessage("ok");
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
