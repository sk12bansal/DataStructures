package rxjava;


import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.Arrays;
import java.util.List;

public class OperatorRxJava {

    public static void main(String [] args){

        /*
            The Action callback is used to reduce the verbosity of the subscriber.
            Action1<T> is equivalent to onNext() where T is the type emitted.
            Action0 is equivalent to onComplete()
            Action1<Throwable> is equivalent to onError(Throwable)
        */
        Observable.just(1,2,3)
                .map(new Func1<Integer, Integer>() {

                    @Override
                    public Integer call(Integer integer) {
                        return integer*integer;
                    }
                })
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println(integer);
                    }
                });


        System.out.println("lambda expressions to reduce the verbosity ");
        List<Integer> list = Arrays.asList(3,5,6,8,9,2,3,4,0,4,2);
        Observable.from(list)
                .map(i->{
                    if(i%2==0){
                        return  i;
                    }else{
                        return i*i;
                    }
                })
                .filter(integer -> integer>1)
                .subscribe(System.out::println);
    }
}
