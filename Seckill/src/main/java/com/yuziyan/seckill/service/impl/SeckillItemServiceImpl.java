package com.yuziyan.seckill.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.yuziyan.seckill.dao.RedisDao;
import com.yuziyan.seckill.dao.SeckillItemDao;
import com.yuziyan.seckill.dto.SeckillUrl;
import com.yuziyan.seckill.entity.SeckillItem;
import com.yuziyan.seckill.service.SeckillItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SeckillItemServiceImpl implements SeckillItemService {

    @Autowired
    SeckillItemDao seckillItemDao;
    @Autowired
    RedisDao redisDao;

    @Override
    public List<SeckillItem> getSeckillItemList() {
        return seckillItemDao.getAllSeckillItems();
    }

    @Override
    public SeckillItem getSeckillItem(Integer id) {
        return seckillItemDao.getSeckillItemById(id);
    }

    @Override
    public SeckillUrl getSeckillUrl(Integer itemId) {
        SeckillUrl seckillUrl = new SeckillUrl();
        seckillUrl.setItemId(itemId);

        //判断这个商品的是否在活动时间：
        // 获取这个商品，先从redis中拿
        SeckillItem seckillItem = (SeckillItem) redisDao.get(itemId.toString());
        if (ObjectUtil.isEmpty(seckillItem)) {
            //redis缓存中没有，从MySQL中拿
            seckillItem = seckillItemDao.getSeckillItemById(itemId);
            if (ObjectUtil.isEmpty(seckillItem)) {
                //数据库中没有这个id的商品
                //设置为不可用，然后返回
                seckillUrl.setEnable(false);
                return seckillUrl;
            }
            //存入redis，后面的用户就可以直接从redis缓存中获取了
            redisDao.set(itemId.toString(), seckillItem);
        }
        // 判断时间：
        long startTime = seckillItem.getStartTime().getTime();
        long endTime = seckillItem.getEndTime().getTime();
        long curTime = new Date().getTime();
        if (curTime < startTime || curTime >= endTime) {
            //不在活动期间，设置为不可用，然后返回
            seckillUrl.setEnable(false);
            return seckillUrl;
        }

        //通过了验证，需要生成MD5字串
        String md5Str = this.generateMd5Str(itemId);
        seckillUrl.setMd5(md5Str);
        //设置可用
        seckillUrl.setEnable(true);
        return seckillUrl;
    }

    //用于混淆md5的key
    private static final String mixKey = "DGS_8$2@sh";
    private String generateMd5Str(Integer itemId) {
        return DigestUtil.md5Hex(mixKey + "," + itemId);
    }
}
