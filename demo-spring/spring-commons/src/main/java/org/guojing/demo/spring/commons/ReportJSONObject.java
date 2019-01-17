package org.guojing.demo.spring.commons;

import com.alibaba.fastjson.JSONObject;

/**
 * Created at: 2016-12-24
 *
 * @author guojing
 */
public class ReportJSONObject extends JSONObject {

    public ReportJSONObject() {
        super();
    }

    public static ReportJSONObject newObject() {
        return new ReportJSONObject();
    }

    public ReportJSONObject append(String key, String value) {
        this.put(key, value);
        return this;
    }

    public ReportJSONObject append(String key, Number value) {
        this.put(key, value);
        return this;
    }

    public ReportJSONObject append(String key, Boolean value) {
        this.put(key, value);
        return this;
    }

    public ReportJSONObject append(String key, Object value) {
        this.put(key, value);
        return this;
    }
}
