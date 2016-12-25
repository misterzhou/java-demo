package org.guojing.guice;

/**
 * Created at: 2016-04-07
 *
 * @author guojing
 */
public class MockConnection {

    public void connection() {
        System.out.println("connection to database");
    }

    public void disConnection() {
        System.out.println("disconnection databse");
    }
}
