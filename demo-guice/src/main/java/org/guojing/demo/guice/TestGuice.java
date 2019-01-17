package org.guojing.demo.guice;

import com.google.inject.*;
import com.google.inject.name.Names;

/**
 * Created at: 2016-04-07
 *
 * @author guojing
 */
public class TestGuice {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(HelloWorld.class).to(SayHelloWorld.class);
                bind(Storage.class).annotatedWith(Names.named("mem")).to(MemStorage.class);
                bind(Storage.class).annotatedWith(Names.named("redis")).to(RedisStrage.class);
                bind(MockConnection.class).toProvider(JDBCConnectionProvider.class).in(Singleton.class);
            }
        });

        HelloWorld helloWorld = injector.getInstance(HelloWorld.class);
        helloWorld.say();

        String key = "key";
        String value = "value";

        Storage memStorage = injector.getInstance(Key.get(Storage.class, Names.named("mem")));
        Storage redisStorage = injector.getInstance(Key.get(Storage.class, Names.named("redis")));
        memStorage.get(key);
        redisStorage.get(key);

        MockConnection connection = injector.getInstance(MockConnection.class);
        connection.connection();
        connection.disConnection();
    }
}
