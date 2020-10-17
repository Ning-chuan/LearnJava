package com.yuziyan.seckill.service.impl;

import com.yuziyan.seckill.dao.SeckillItemDao;
import com.yuziyan.seckill.entity.SeckillItem;
import com.yuziyan.seckill.service.SeckillItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeckillItemServiceImpl implements SeckillItemService {

    @Autowired
    SeckillItemDao seckillItemDao;

    @Override
    public List<SeckillItem> getSeckillItemList() {
        return seckillItemDao.getAllSeckillItems();
    }
}
