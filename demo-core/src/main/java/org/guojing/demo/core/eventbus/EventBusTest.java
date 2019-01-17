package org.guojing.demo.core.eventbus;

/**
 * Created at: 2018-11-15 21:02
 *
 * @author guojing
 */
public class EventBusTest {

    public static void main(String[] args) {
        MyEventBus eventBus = new MyEventBus();
        eventBus.register(new EventListener());
        eventBus.postEvent("Hello World");
        eventBus.postEvent(111);
    }

}
