package org.guojing.guice;

/**
 * Created at: 2016-04-09
 *
 * @author guojing
 */
public class SayHelloWorld implements HelloWorld {

    @Override
    public void say() {
        System.out.println("hello world");
    }
}
