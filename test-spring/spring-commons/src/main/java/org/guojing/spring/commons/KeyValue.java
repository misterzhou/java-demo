package org.guojing.spring.commons;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created at: 2016-12-24
 *
 * @author guojing
 */
public class KeyValue<K, V> implements Map.Entry<K, V> {

    private K key;
    private V value;

    public KeyValue() {
    }

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    public JSONObject toJSONObject() {
        return ReportJSONObject.newObject().append(String.valueOf(key), value);
    }

    @Override
    public String toString() {
        return toJSONObject().toJSONString();
    }

}
