package DesignPatterns.ObserverPattern;

import java.util.Arrays;

public class Youtube {
    public static void main(String args[]){
        Channel android = new Channel();
        int [] a = new int[10];


        Observer s1 = new Subscriber("Suraj");
        Observer s2 = new Subscriber("Deepak");
        Observer s3 = new Subscriber("Rohan");
        Observer s4 = new Subscriber("Mohan");
        Observer s5 = new Subscriber("Raju");

        android.subscribe(s1);
        android.subscribe(s2);
        android.subscribe(s3);
        android.subscribe(s4);
        android.subscribe(s5);

        android.unSubscribe(s2);

        s1.subscribeChannel(android);
        s2.subscribeChannel(android);
        s3.subscribeChannel(android);
        s4.subscribeChannel(android);
        s5.subscribeChannel(android);

        android.upload("How to Learn android?");
    }
}
