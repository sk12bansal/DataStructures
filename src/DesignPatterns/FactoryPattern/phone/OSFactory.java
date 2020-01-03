package DesignPatterns.FactoryPattern.phone;

public class OSFactory {

    public OS getInstance(String str) {
        if (str.equals("Android")) {
            return new Android();
        } else if (str.equals("IOS")) {
            return new IOS();
        } else {
            return new Windows();
        }
    }
}
