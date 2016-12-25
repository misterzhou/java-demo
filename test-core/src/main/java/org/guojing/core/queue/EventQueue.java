package org.guojing.core.queue;

/**
 * Created at: 2016-05-26
 *
 * @author guojing
 */
public interface EventQueue {

    void registerConsumer(QueueConsumer consumer);

    void stop();

    void publish(Object object);
}
