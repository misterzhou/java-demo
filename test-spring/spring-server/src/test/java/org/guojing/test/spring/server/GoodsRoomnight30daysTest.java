package org.guojing.test.spring.server;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.guojing.spring.commons.KeyValue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created at: 2016-12-24
 *
 * @author guojing
 */
public class GoodsRoomnight30daysTest {

    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    GoodsRoomnight30daysMapper goodsRoomnight30daysMapper;

    @Before
    public void init() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        goodsRoomnight30daysMapper = sqlSession.getMapper(GoodsRoomnight30daysMapper.class);
    }

    @Test
    public void test() {
        List<KeyValue<Long, Integer>> records = new ArrayList<>();
        records.add(new KeyValue<Long, Integer>(1725L, 5));
        records.add(new KeyValue<Long, Integer>(1728L, 3));
        records.add(new KeyValue<Long, Integer>(1730L, null));
        records.add(new KeyValue<Long, Integer>(1758L, null));

        int deleted = goodsRoomnight30daysMapper.deleteByExample(new GoodsRoomnight30daysExample());
        System.out.println("----- deleted row size: " + deleted);
        int row = goodsRoomnight30daysMapper.insertBatch(records);
        System.out.println("----- affected row: " + row);
        List<GoodsRoomnight30days> result = goodsRoomnight30daysMapper.selectByExample(new GoodsRoomnight30daysExample());
        for (GoodsRoomnight30days item : result) {
            System.out.println(item.toString());
        }
    }

    @After
    public void after() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
