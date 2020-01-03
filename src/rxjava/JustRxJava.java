package rxjava;

import rx.Observable;
import rx.Observer;

public class JustRxJava {
    public static void main(String args[]){
        Observable<Integer>  justObservable = Observable.just(4,6,6,null);

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        };

        justObservable.subscribe(observer);
    }
}
