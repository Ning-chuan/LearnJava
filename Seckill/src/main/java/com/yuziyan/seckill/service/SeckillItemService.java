package com.yuziyan.seckill.service;

import com.yuziyan.seckill.entity.SeckillItem;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SeckillItemService {
    List<SeckillItem> getSeckillItemList();

    SeckillItem getSeckillItem(Integer id);
}
