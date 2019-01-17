package org.guojing.demo.core;

import org.junit.Test;

import java.util.*;

/**
 * Created at: 2016-05-25
 *
 * @author guojing
 */
public class MapTest {

    @Test
    public void putNullKeyNull() {
        Map<String, String> map = new HashMap<>();
        map.put(null, "a");
        map.put("111", "111value");
        map.put("111", null);
        map.put(null, null);
        map.put("222", "222value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Map<Integer, Integer> intmap = new HashMap<>();
        intmap.put(1,1);
        intmap.put(2,2);
        Set<Map.Entry<Integer, Integer>> entries = intmap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Test
    public void testArrayList() {
        List<String> list = new ArrayList<>(5);
        int len = list.size();
        for (int i = 0; i < 5; i++) {
            list.add("key" + i);
        }
        list.add("aaa");
        list.add(null);
        System.out.println(list.size());
    }
}
