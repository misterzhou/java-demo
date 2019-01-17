package org.guojing.demo.core.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * Created at: 2018-11-15 20:58
 *
 * @author guojing
 */
public class MyEventBus {

    private EventBus eventBus = new EventBus();

    public void register(EventListener eventListener) {
        eventBus.register(eventListener);
    }

    public void postEvent(String msg) {
        eventBus.post(msg);
    }

    public void postEvent(int msg) {
        eventBus.post(msg);
    }

}
