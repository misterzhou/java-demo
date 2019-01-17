package org.guojing.demo.spring.server;

import org.apache.ibatis.annotations.Param;
import org.guojing.demo.spring.commons.KeyValue;

import java.util.List;

/**
 * Created at: 2016-12-24
 *
 * @author guojing
 */
public interface GoodsRoomnight30daysMapper {

    int countByExample(GoodsRoomnight30daysExample example);

    int deleteByExample(GoodsRoomnight30daysExample example);

    int deleteByPrimaryKey(Long goodsId);

    int insert(GoodsRoomnight30days record);

    int insertSelective(GoodsRoomnight30days record);

    List<GoodsRoomnight30days> selectByExample(GoodsRoomnight30daysExample example);

    GoodsRoomnight30days selectByPrimaryKey(Long goodsId);

    int updateByExampleSelective(@Param("record") GoodsRoomnight30days record, @Param("example") GoodsRoomnight30daysExample example);

    int updateByExample(@Param("record") GoodsRoomnight30days record, @Param("example") GoodsRoomnight30daysExample example);

    int updateByPrimaryKeySelective(GoodsRoomnight30days record);

    int updateByPrimaryKey(GoodsRoomnight30days record);

    /**
     * 插入 goods近30天消费间夜的值
     * @param records
     * @return
     */
    <K, V> int insertBatch(List<KeyValue<K, V>> records);

}
