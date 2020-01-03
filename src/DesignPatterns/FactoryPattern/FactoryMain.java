package DesignPatterns.FactoryPattern;

import DesignPatterns.FactoryPattern.phone.OS;
import DesignPatterns.FactoryPattern.phone.OSFactory;

public class FactoryMain {

    public static void main(String args[]){

        OSFactory osFactory = new OSFactory();
        OS obj = osFactory.getInstance("IOS");
        obj.spec();
    }
}
