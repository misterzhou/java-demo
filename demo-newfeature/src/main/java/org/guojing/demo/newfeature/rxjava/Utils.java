package org.guojing.demo.newfeature.rxjava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created at: 2018-11-20 09:01
 *
 * @author guojing
 */
public class Utils {

    public static final int CPU_CORES = Runtime.getRuntime().availableProcessors();
    public static final ExecutorService ASYNC_DISPATCHER_EXECUTOR = new ThreadPoolExecutor(
            CPU_CORES, CPU_CORES, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));

}
