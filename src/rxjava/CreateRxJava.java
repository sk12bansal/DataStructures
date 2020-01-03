package rxjava;


import rx.Observer;
import rx.Subscriber;
import rx.Observable;

public class CreateRxJava {
    public static void main(String args[]){
        Observable<String> createObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                //Code to pass the data to the subscribers and observers goes here.
                //subscriber.onNext("Hello World");
                int i=0;
                while(i<5)
                {
                    subscriber.onNext("Hello World "+ i);
                    i++;
                }
                subscriber.onCompleted();
            }
        });


        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Subscriber complete");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("Subscriber onNext(): "+ s);
            }
        };

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Observer complete");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("MyObserver onNext(): "+ s);
            }
        };

        createObservable.subscribe(subscriber);
        createObservable.subscribe(observer);
    }
}
