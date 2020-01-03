package rxjava;

import rx.Observable;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class FromRxJava {

    public static void main(String args[]){

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Observable<Integer> fromObservable = Observable.from(numbers);

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("fromObservable onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        };

        fromObservable.subscribe(subscriber);
     }
}
