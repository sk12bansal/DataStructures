class A {

    public static void doSomething() {
        System.out.println("doSomething");
    }
}

class B extends A{

    public static void doSomething() {
       System.out.println("doSomething in B");
    }
}

public class Method1 {
    public static void main(String args[]){
        B b1 = new B();
        b1.doSomething();
    }
}
