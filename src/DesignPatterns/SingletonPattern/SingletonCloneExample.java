package DesignPatterns.SingletonPattern;

public class SingletonCloneExample implements Cloneable {
    public static SingletonCloneExample INSTANCE = new SingletonCloneExample();
    private SingletonCloneExample() {

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return INSTANCE;
        //return super.clone();
    }
}

class Solution{
    public static void main(String []args) throws CloneNotSupportedException {
        SingletonCloneExample s1 = SingletonCloneExample.INSTANCE;
        SingletonCloneExample s2 = (SingletonCloneExample) s1.clone();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
