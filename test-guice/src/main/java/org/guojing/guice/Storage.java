package org.guojing.guice;

/**
 * Created at: 2016-04-07
 *
 * @author guojing
 */
public interface Storage {

    void store(String key, String value);

    String get(String key);
}
