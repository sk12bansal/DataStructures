package javaconcepts;

abstract class Base {
    Base(){
        System.out.println("Base Constructor Called");
    }
    abstract void fun();
    void fun1() { System.out.println("Base fun1() called"); }

    final void fun2() { System.out.println("final Base fun2() called"); }
}
class Derived extends Base{

    @Override
    void fun() {
        System.out.println("Derived fun() called");
    }

}
class AbstractEx{
    public static void main(String[] args) {
        Base b = new Derived();
        b.fun();
        b.fun1();
        b.fun2();
    }
}