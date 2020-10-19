package com.yuziyan.seckill.entity;


import java.util.Date;

/**
 * 秒杀订单
 */
public class SeckillOrder {

    private int id;
    private int seckillItemId;
    private int userId;
    // state表示订单的状态
    // 1 下单成功，未支付
    // TODO 未支付还存在一个逻辑
    // 2 已支付
    private int state;
    private Date createTime;

    public SeckillOrder() {
    }
    public SeckillOrder(int seckillItemId, int userId, int state, Date createTime) {
        this.id = id;
        this.seckillItemId = seckillItemId;
        this.userId = userId;
        this.state = state;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeckillItemId() {
        return seckillItemId;
    }

    public void setSeckillItemId(int seckillItemId) {
        this.seckillItemId = seckillItemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SeckillOrder{" +
                "id=" + id +
                ", seckillItemId=" + seckillItemId +
                ", userId=" + userId +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}
