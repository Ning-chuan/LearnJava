package com.yuziyan.seckill.service.impl;

import com.yuziyan.seckill.dao.SeckillOrderDao;
import com.yuziyan.seckill.entity.SeckillOrder;
import com.yuziyan.seckill.service.SeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SeckillOrderServiceImpl implements SeckillOrderService {

    @Autowired
    SeckillOrderDao seckillOrderDao;

    @Override
    public void createOrder(Integer itemId, Integer userId, Integer state) {
        //创建订单
        SeckillOrder seckillOrder = new SeckillOrder(itemId, userId, state, new Date());
        //存到MySQL数据库
        seckillOrderDao.addSeckillOrder(seckillOrder);
    }
}
