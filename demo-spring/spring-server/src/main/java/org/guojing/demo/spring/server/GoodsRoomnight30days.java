package org.guojing.demo.spring.server;

import com.alibaba.fastjson.JSONObject;

/**
 * Created at: 2016-12-24
 *
 * @author guojing
 */
public class GoodsRoomnight30days {

    private Long goodsId;

    private Integer checkinRoomNight30days;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCheckinRoomNight30days() {
        return checkinRoomNight30days;
    }

    public void setCheckinRoomNight30days(Integer checkinRoomNight30days) {
        this.checkinRoomNight30days = checkinRoomNight30days;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
