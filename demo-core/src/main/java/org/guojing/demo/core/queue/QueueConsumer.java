package org.guojing.demo.core.queue;

/**
 * Created at: 2016-05-26
 *
 * @author guojing
 */
public interface QueueConsumer<T> {

    void consume(T msg);
}
