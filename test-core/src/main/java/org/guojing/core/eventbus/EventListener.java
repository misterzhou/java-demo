package org.guojing.core.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * Created at: 2018-11-15 21:00
 *
 * @author guojing
 */
public class EventListener {

    @Subscribe
    public void stringEvent(String msg) {
        System.out.println("stringEvent: " + msg);
    }

    @Subscribe
    public void intEvent(Integer intMsg) {
        System.out.println("intEvent: " + intMsg);
    }

}
