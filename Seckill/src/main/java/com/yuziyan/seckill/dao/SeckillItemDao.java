package com.yuziyan.seckill.dao;

import com.yuziyan.seckill.entity.SeckillItem;

import java.util.List;

public interface SeckillItemDao {
    List<SeckillItem> getAllSeckillItems();

    SeckillItem getSeckillItemById(Integer id);
}
