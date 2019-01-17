package org.guojing.demo.guice;

import com.google.inject.Provider;

/**
 * Created at: 2016-04-07
 *
 * @author guojing
 */
public class JDBCConnectionProvider implements Provider<MockConnection> {

    @Override
    public MockConnection get() {
        return new MockConnection();
    }
}
