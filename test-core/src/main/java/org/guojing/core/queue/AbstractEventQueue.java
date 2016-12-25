package org.guojing.core.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created at: 2016-05-26
 *
 * @author guojing
 */
public abstract class AbstractEventQueue implements EventQueue {

    protected List<QueueConsumer> consumers = new ArrayList<>();

    @Override
    public void registerConsumer(QueueConsumer consumer) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void publish(Object object) {

    }


}
