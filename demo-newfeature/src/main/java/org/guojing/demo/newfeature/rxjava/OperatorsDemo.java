package org.guojing.demo.newfeature.rxjava;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created at: 2018-11-19 20:56
 *
 * @author guojing
 */
public class OperatorsDemo {

    private AtomicInteger preFilterIndex = new AtomicInteger(0);
    private AtomicInteger postFilterIndex = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        OperatorsDemo operatorsDemo = new OperatorsDemo();
        System.out.println("main: " + Thread.currentThread().getName());
//        operatorsDemo.execPreFilterAsync(Schedulers.from(Utils.ASYNC_DISPATCHER_EXECUTOR));
        operatorsDemo.execPreFilterAsync(Schedulers.computation());

        Thread.sleep(3000);
    }

    private void execPreFilterAsync(Scheduler scheduler) {
        int index = preFilterIndex.getAndIncrement();
        if (index == 3) {
            execEndPointAsync(scheduler);
            return;
        }

        Observable.create(emitter -> {
            System.out.println(Thread.currentThread().getName() + ": execPreFilterAsync-create, currentPreIndex = " + index);
            emitter.onNext("pre");
            emitter.onComplete();
        }).observeOn(scheduler).subscribe(o -> {
            System.out.println(Thread.currentThread().getName() + ": execPreFilterAsync-subscribe, msg: " + o);
            execPreFilterAsync(scheduler);
        });

    }

    private void execEndPointAsync(Scheduler scheduler) {
        Observable.create(emitter -> {
            System.out.println(Thread.currentThread().getName() + ": execEndPointAsync-create");
            emitter.onNext("endpoint");
            emitter.onComplete();
        }).observeOn(scheduler).subscribe(o -> {
            System.out.println(Thread.currentThread().getName() + ": execEndPointAsync-subscribe, msg: " + o);
            execPostFilterAsync(scheduler);
        });
    }

    private void execPostFilterAsync(Scheduler scheduler) {
        int index = postFilterIndex.getAndIncrement();
        if (index == 2) {
            return;
        }

        Observable.create(emitter -> {
            System.out.println(Thread.currentThread().getName() + ": execPostFilterAsync-create, currentPostIndex = " + index);
            emitter.onNext("post");
            emitter.onComplete();
        }).observeOn(scheduler).subscribe(o -> {
            System.out.println(Thread.currentThread().getName() + ": execPostFilterAsync-subscribe, msg: " + o);
            execPostFilterAsync(scheduler);
        });

        Observable.create(emitter -> {
            System.out.println(Thread.currentThread().getName() + ": execPostFilterAsync-create, currentPostIndex = " + index);
            emitter.onNext("post");
            emitter.onComplete();
        }).observeOn(scheduler).subscribe();

    }

}
