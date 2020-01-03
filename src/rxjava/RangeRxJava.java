package rxjava;

import rx.Observable;
import rx.Observer;

import java.util.concurrent.TimeUnit;

public class RangeRxJava {

    public static void main(String args[]) throws InterruptedException {

        Observable<Integer> rangeObservable = Observable.range(2,5);

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted: ");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: "+integer);
            }
        };

        rangeObservable.subscribe(observer);

        Observable intervalObservable = Observable.interval(1, TimeUnit.SECONDS);
        intervalObservable.subscribe(System.out::println);
        Thread.sleep(5000);
    }
}
