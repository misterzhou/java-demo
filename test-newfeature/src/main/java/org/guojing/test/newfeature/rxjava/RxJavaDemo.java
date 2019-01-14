package org.guojing.test.newfeature.rxjava;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created at: 2018-11-18 17:30
 *
 * @author guojing
 */
public class RxJavaDemo {

    public static void main(String[] args) throws Exception {
        RxJavaDemo rxJavaDemo = new RxJavaDemo();

        Flowable.range(0, 10)
                .map(item -> item * item)
                .filter(item -> item % 3 == 0)
                .subscribe(System.out::println);

        Observable.create(emitter -> {
            while (!emitter.isDisposed()) {
                long time = System.currentTimeMillis();
                emitter.onNext(time);
                if (time % 2 != 0) {
                    emitter.onError(new IllegalStateException("old millisecond"));
                    break;
                }
            }
        }).subscribe(System.out::println, Throwable::printStackTrace);

//        Flowable.fromCallable(() -> {
//            Thread.sleep(1000); //  imitate expensive computation
//            return "Done";
//        }).subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.single())
//                .subscribe(System.out::println, Throwable::printStackTrace);
//
//
//        Flowable.range(1, 10)
//                .observeOn(Schedulers.computation())
//                .map(v -> v * v)
//                .blockingSubscribe(System.out::println);

//        Flowable.range(1, 10)
//                .flatMap(v -> Flowable.just(v)
//                        .subscribeOn(Schedulers.computation())
//                        .map(w -> w * w))
//                .blockingSubscribe(System.out::println);

//        Observable.fromArray("a", "b", "c")
//                .observeOn(Schedulers.computation())
//                .doOnSubscribe(disposable -> {
//                    System.out.println(Thread.currentThread().getName() + ": doOnSubscribe");
//                })
//                .doOnNext(s -> System.out.println(Thread.currentThread().getName() + ": doOnNext, msg: " + s))
//                .doAfterNext(s -> System.out.println(Thread.currentThread().getName() + ": doAfterNext, msg: " + s))
//                .subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                System.out.println(Thread.currentThread().getName() + ": onSubscribe");
//            }
//
//            @Override
//            public void onNext(String s) {
//                System.out.println(Thread.currentThread().getName() + ": onNext, msg:" + s);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println(Thread.currentThread().getName() + ": onComplete");
//            }
//        });

        Observable.create(emitter -> {
            System.out.println(Thread.currentThread().getName() + ": create");
            emitter.onNext("hello");
            emitter.onComplete();
//            emitter.onError(new Throwable("occur error"));
//            throw new Exception("test twice invoke doOnError exception");
        })
//                .doOnError(throwable -> System.out.println(Thread.currentThread().getName() + ": first doOnError, error: " + throwable))
                .observeOn(Schedulers.computation())
                .doOnSubscribe(disposable -> System.out.println(Thread.currentThread().getName() + ": doOnSubscribe"))
                .doOnNext(s -> System.out.println(Thread.currentThread().getName() + ": doOnNext, msg: " + s))
                .doAfterNext(s -> System.out.println(Thread.currentThread().getName() + ": doAfterNext, msg: " + s))
                .doOnError(throwable -> System.out.println(Thread.currentThread().getName() + ": doOnError, error: " + throwable))
                .doOnComplete(() -> System.out.println(Thread.currentThread().getName() + ": doOnComplete"))
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println(Thread.currentThread().getName() + ": onSubscribe");
                    }

                    @Override
                    public void onNext(Object o) {
                        System.out.println(Thread.currentThread().getName() + ": onNext, msg:" + o);
                        try {
                            System.out.println(Thread.currentThread().getName() + ": do some thing");
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(Thread.currentThread().getName() + ": onError, e:" + e);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println(Thread.currentThread().getName() + ": onComplete");
                    }
                });

        Thread.sleep(3000);
        System.out.println("**************************");

        System.out.println("***** startTime: " + System.currentTimeMillis());
//        Observable.just(rxJavaDemo.apply()).observeOn(Schedulers.computation());
        Observable.create(emitter -> {
            System.out.println("***** time2: " + System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() + ": create");
            throw new Exception("simple exception");
//            emitter.onNext("hello");
//            emitter.onComplete();
//            emitter.onError(new Throwable("occur error"));
        }).compose(logTransform())
//                .compose(monitorTransform())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("***** onSubscribe time: " + System.currentTimeMillis());
                        System.out.println(Thread.currentThread().getName() + ": onSubscribe");
                    }

                    @Override
                    public void onNext(Object o) {
                        System.out.println(Thread.currentThread().getName() + ": onNext, msg:" + o);
                        try {
                            System.out.println(Thread.currentThread().getName() + ": do some thing");
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ": onNext done");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(Thread.currentThread().getName() + ": onError, e:" + e);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println(Thread.currentThread().getName() + ": onComplete");
                    }
                });

        Thread.sleep(3000);
    }

    private boolean apply() throws Exception {
        Thread.sleep(1000);
        System.out.println("***** apply time: " + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() + ": apply");
        return true;
    }

    private static <T> ObservableTransformer<T, T> logTransform() {
        return upstream -> upstream
                .doOnSubscribe(disposable -> {
                    System.out.println(Thread.currentThread().getName() + ": doOnSubscribe");
                    System.out.println("***** doOnSubscribe time: " + System.currentTimeMillis());
                })
                .doOnNext(s -> System.out.println(Thread.currentThread().getName() + ": doOnNext, msg: " + s))
                .doAfterNext(s -> System.out.println(Thread.currentThread().getName() + ": doAfterNext, msg: " + s))
                .doOnError(throwable -> System.out.println(Thread.currentThread().getName() + ": doOnError, error: " + throwable))
                .doOnComplete(() -> System.out.println(Thread.currentThread().getName() + ": doOnComplete"));
    }

    private static <T> ObservableTransformer<T, T> monitorTransform() {
        return upstream -> upstream
                .doOnSubscribe(disposable -> System.out.println("Monitor - " + Thread.currentThread().getName() + ": doOnSubscribe"))
                .doOnNext(s -> System.out.println("Monitor - " + Thread.currentThread().getName() + ": doOnNext, msg: " + s))
                .doAfterNext(s -> System.out.println("Monitor - " + Thread.currentThread().getName() + ": doAfterNext, msg: " + s))
                .doOnError(throwable -> System.out.println("Monitor - " + Thread.currentThread().getName() + ": doOnError, error: " + throwable))
                .doOnComplete(() -> System.out.println("Monitor - " + Thread.currentThread().getName() + ": doOnComplete"));
    }

}
