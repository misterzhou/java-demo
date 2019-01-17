package org.guojing.demo.guice;

/**
 * Created at: 2016-04-07
 *
 * @author guojing
 */
public class MemStorage implements Storage {

    @Override
    public void store(String key, String value) {
        System.out.println("store to mem");
    }

    @Override
    public String get(String key) {
        System.out.println("get value from mem");
        return "mem_value";
    }
}
